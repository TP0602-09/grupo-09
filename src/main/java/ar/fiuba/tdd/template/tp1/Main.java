package ar.fiuba.tdd.template.tp1;

import java.util.Scanner;

/**
 * Created by Lucía on 17/10/2016.
 */
public class Main {

    public static void main(String[] args) {
        GameReader gameReader = GameReader.getInstance();
        Scanner sc = new Scanner(System.in, "UTF-8");
        try {
            System.out.println("Welcome to our game machine!");
            System.out.println("Please enter the name of the game you want to play (in lower case letters)...");
            String gameName = sc.nextLine();
            GameData gameData = gameReader.readGameConfiguration(gameName);
            Board board = new Board(gameData.getRows(), gameData.getColumns(), gameData.getSectors());
            Game game = new Game(board, gameData.getInputType(), gameData.getUnionType(),
                    gameData.getEveryPlayRules(), gameData.getFinalRules());
            game.play();
            System.out.print("Thanks for playing");
        } catch (GameNotFoundException e) {
            System.out.print("The game hat not been found");
        }
    }
}
