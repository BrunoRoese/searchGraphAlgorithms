import game.CreateGame;
import game.GameRules;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        var createGame = new CreateGame();
        var gameRules = new GameRules();
        var steps = new LinkedList<>();
        var continueGame = true;
        int[][] currentState = createGame.getInitialState();

        while (continueGame) {
            if (currentState == createGame.getGoalState()) {
                continueGame = false;
                break;
            }
        }
    }
}