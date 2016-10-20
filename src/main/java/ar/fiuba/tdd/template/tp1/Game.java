package ar.fiuba.tdd.template.tp1;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    private Board board;
    private String inputType;
    private String unionType;
    private InputFileReader inputFileReader;
    private OutputFileMaker outputFileMaker;

    public Game(Board board, String inputType, String unionType) {
        this.board = board;
        this.inputType = inputType;
        this.unionType = unionType;
        this.inputFileReader = new InputFileReader();
        this.outputFileMaker = new OutputFileMaker();
    }

    public boolean make(Play play) {
        play.doIt(board);
        return validate(board);
    }

    public boolean validate(Board board) {
        //TODO implement method
        return true;
    }

    private boolean validateFinal(Board board) {
        return true;
    }

    public void play() {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.print("Enter your input file destination");
        String path = sc.nextLine();
        System.out.print("Reading input file...");
        try {
            InputData inputData = inputFileReader.read(path);
            System.out.print("Playing...");
            for (Play onePlay : inputData.getPlays()) {
                if (make(onePlay)) {
                    board.update(onePlay);
                } else {
                    onePlay.isInvalid();
                }
            }
            System.out.print("Generating final status");

            outputFileMaker.make(board, inputData.getPlays(), validateFinal(board));
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
