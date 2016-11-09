package ar.fiuba.tdd.template.tp1;

import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public class OutputFileMaker {

    public void make(Board board, List<Play> plays, boolean finalStatus) {
        OutputBoard outputBoard = new OutputBoard();
        outputBoard.setStatus(finalStatus);
        outputBoard.setSectors(board.getSectors());
        OutputData outputData = new OutputData();
        outputData.setPlays(plays);
        outputData.setBoard(outputBoard);
        Gson gson = new Gson();
        String result = gson.toJson(outputData);
        String path = System.getProperty("user.dir") + "/resources/results.json";
        try {
            File file = new File(path);
            Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            writer.write(result);
            System.out.println("Successfully generated results file.");
            System.out.println("You can check your results here: " + path);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while generating the results file. " + e.getMessage());
        }
    }

}
