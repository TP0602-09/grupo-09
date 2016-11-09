package ar.fiuba.tdd.template.tp1;

import java.util.Stack;

/**
 * Created by Lucía on 9/11/2016.
 */
public class UndoPlay extends Play {
    @Override
    public void doIt(Board board) {
        Stack<Play> madePlays = board.getMadePlays();
        if (madePlays.size() > 0) {
            madePlays.pop().rollback(board);
            System.out.println("You are going to undo your last play");
        }
    }

    @Override
    public void rollback(Board board) {

    }
}
