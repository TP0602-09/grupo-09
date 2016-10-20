package ar.fiuba.tdd.template.tp1;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Lucía on 18/10/2016.
 */
public class OutputFileWriter {

    public void make(Board board, List<Play> plays, boolean finalStatus) {
        OutputBoard outputBoard = new OutputBoard();
        outputBoard.setStatus(finalStatus);
        outputBoard.setSectors(board.getSectors());
        OutputData outputData = new OutputData();
        outputData.setPlays(plays);
        outputData.setBoard(outputBoard);
        Gson gson = new Gson();
        String result = gson.toJson(outputData);
        System.out.print("The final status is...");
        System.out.print(result);
    }

}
