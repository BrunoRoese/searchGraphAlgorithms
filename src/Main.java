import algorithms.BfsFactory;
import algorithms.GreedyBestSearchFirstFactory;
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

            BfsFactory bfsFactory = new BfsFactory(currentState, createGame.getGoalState(), gameRules);

            System.out.println(bfsFactory.execute());

            System.out.println("Executing...");

            var greedyBestSearchFirstFactory = new GreedyBestSearchFirstFactory(currentState, createGame.getGoalState(), gameRules);

            System.out.println(greedyBestSearchFirstFactory.execute());
        } else {
            System.out.println("Not solvable");
        }
    }
}