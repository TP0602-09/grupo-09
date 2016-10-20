package ar.fiuba.tdd.template.tp1;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    private Board board;
    private String inputType;
    private String unionType;
    private InputFileReader inputFileReader;
    private OutputFileWriter outputFileMaker;

    public Game(Board board, String inputType, String unionType) {
        this.board = board;
        this.inputType = inputType;
        this.unionType = unionType;
        this.inputFileReader = new InputFileReader();
        this.outputFileMaker = new OutputFileWriter();
    }

    public boolean make(Play play) {
        play.doIt(board);
        return board.validate();
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
                }
            }
            System.out.print("Generating output file in directory 'C:/Users/'");
            outputFileMaker.make(board);
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
