import bfs.BfsExecution;
import game.CreateGame;
import game.GameRules;
import game.PuzzleChecker;

public class Main {

    public static void main(String[] args) {
        var createGame = new CreateGame();
        var gameRules = new GameRules();
        var puzzleChecker = new PuzzleChecker();
        int[][] currentState = createGame.getInitialState();

        if (puzzleChecker.isSolvable(createGame.getInitialState())) {
            System.out.println("Executing...");

            BfsExecution bfsExecution = new BfsExecution(currentState, createGame.getGoalState(), gameRules);

            System.out.println(bfsExecution.executeBfs());
        } else {
            System.out.println("Not solvable");
        }
    }
}