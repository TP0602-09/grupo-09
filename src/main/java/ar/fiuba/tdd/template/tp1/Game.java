package ar.fiuba.tdd.template.tp1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Board board;
    private String inputType;
    private String unionType;
    private InputFileReader inputFileReader;
    private OutputFileMaker outputFileMaker;
    private List<Rule> everyPlayRules;
    private List<Rule> finalRules;

    public Game(Board board, String inputType, String unionType,
                List<Rule> everyPlayRules, List<Rule> finalRules) {
        this.board = board;
        this.everyPlayRules = everyPlayRules;
        this.finalRules = finalRules;
        this.inputType = inputType;
        this.unionType = unionType;
        this.inputFileReader = new InputFileReader();
        this.outputFileMaker = new OutputFileMaker();
    }

    private void makePlay(Play play) {
        play.doIt(board);
        if (!validateBoard(everyPlayRules)) {
            System.out.println("The state is invalid now. Try to undo.");
            play.setInvalid();
        }
    }

    private boolean validateBoard(List<Rule> rules) {
        for (Rule rule : rules) {
            if (!rule.isValidBoard(board)) {
                return false;
            }
        }
        return true;
    }

    public void play() {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Enter your input file name");
        String name = sc.nextLine();
        System.out.println("Reading input file...");
        try {
            InputData inputData = inputFileReader.read(name);
            System.out.println("Playing...");
            inputData.getPlays().forEach(this::makePlay);
            System.out.println("Generating final status");
            boolean finalStatus = validateBoard(finalRules);
            if (finalStatus) {
                System.out.println("Congratulations! You won!!");
            } else {
                System.out.println("Sorry you lost... May be next time");
            }
            outputFileMaker.make(board, inputData.getPlays(), finalStatus);
        } catch (IOException e) {
            System.out.print("Input not found");
        }

    }

    public String getInputType() {
        return this.inputType;
    }

    public String getUnionType() {
        return this.unionType;
    }

}
