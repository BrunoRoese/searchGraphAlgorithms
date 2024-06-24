package game;

import java.util.Arrays;
import java.util.List;

public class GameRules {

    public List<PossibleMoves> possibleMoves(int currentMatrixPosition, int currentListPosition) {
        if (currentMatrixPosition == 0) {
            switch (currentListPosition) {
                case 0 -> {
                    return List.of(PossibleMoves.RIGHT, PossibleMoves.DOWN);
                }
                case 1 -> {
                    return List.of(PossibleMoves.LEFT, PossibleMoves.RIGHT, PossibleMoves.DOWN);
                }
                case 2 -> {
                    return List.of(PossibleMoves.LEFT, PossibleMoves.DOWN);
                }
            }
        }

        if (currentMatrixPosition == 1) {
            switch (currentListPosition) {
                case 0 -> {
                    return List.of(PossibleMoves.RIGHT, PossibleMoves.UP, PossibleMoves.DOWN);
                }
                case 1 -> {
                    return List.of(PossibleMoves.LEFT, PossibleMoves.RIGHT, PossibleMoves.UP, PossibleMoves.DOWN);
                }
                case 2 -> {
                    return List.of(PossibleMoves.LEFT, PossibleMoves.UP, PossibleMoves.DOWN);
                }
            }
        }

        if (currentMatrixPosition == 2) {
            switch (currentListPosition) {
                case 0 -> {
                    return List.of(PossibleMoves.RIGHT, PossibleMoves.UP);
                }
                case 1 -> {
                    return List.of(PossibleMoves.LEFT, PossibleMoves.RIGHT, PossibleMoves.UP);
                }
                case 2 -> {
                    return List.of(PossibleMoves.LEFT, PossibleMoves.UP);
                }
            }
        }

        return List.of();
    }

    // int i and int j represent the position of the empty cell
    public int[][] generateNewMoves(int[][] currentState, PossibleMoves possibleMove, int i, int j) {
        int[][] currentStateCopy = Arrays.stream(currentState)
                .map(int[]::clone)
                .toArray(int[][]::new);

        switch (possibleMove) {
            case UP -> {
                var currentStateNumber = currentStateCopy[i - 1][j];
                currentStateCopy[i][j] = currentStateNumber;
                currentStateCopy[i - 1][j] = 0;

                return currentStateCopy;
            }
            case DOWN -> {
                var currentStateNumber = currentStateCopy[i + 1][j];
                currentStateCopy[i][j] = currentStateNumber;
                currentStateCopy[i + 1][j] = 0;

                return currentStateCopy;
            }
            case LEFT -> {
                var currentStateNumber = currentStateCopy[i][j - 1];
                currentStateCopy[i][j] = currentStateNumber;
                currentStateCopy[i][j - 1] = 0;

                return currentStateCopy;
            }
            case RIGHT -> {
                var currentStateNumber = currentStateCopy[i][j + 1];
                currentStateCopy[i][j] = currentStateNumber;
                currentStateCopy[i][j + 1] = 0;

                return currentStateCopy;
            }
            default -> {
                return currentState;
            }
        }
    }
}
