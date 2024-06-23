package game;

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
}
