import bfs.BfsExecution;
import game.CreateGame;
import game.GameRules;

public class Main {

    public static void main(String[] args) {
        var createGame = new CreateGame();
        var gameRules = new GameRules();
        int[][] currentState = createGame.getInitialState();

        BfsExecution bfsExecution = new BfsExecution(currentState, createGame.getGoalState(), gameRules);

        System.out.println(bfsExecution.executeBfs());
    }
}