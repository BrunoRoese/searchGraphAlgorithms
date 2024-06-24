package algorithms;

import game.GameRules;
import game.PossibleMoves;

import java.util.*;

public class BfsFactory implements SearchAlgorithm {

    private final LinkedList<int[][]> openStateList = new LinkedList<>();
    private final LinkedList<int[][]> closedStateList = new LinkedList<>();
    private final int[][] goalState;
    private final GameRules gameRules;

    public BfsFactory(int[][] initialState, int[][] goalState, GameRules gameRules) {
        this.goalState = goalState;
        openStateList.add(initialState);
        this.gameRules = gameRules;
    }

    @Override
    public boolean execute() {
        Optional<PossibleMoves> lastMove = Optional.empty();
        int counter = 0;

        while (!openStateList.isEmpty()) {
            int[][] currentState = openStateList.removeFirst();

            if (Arrays.deepEquals(currentState, goalState)) {
                System.out.println(counter);
                return true;
            }

            for (int i = 0; i < currentState.length; i++) {
                for (int j = 0; j < currentState[i].length; j++) {
                    if (currentState[i][j] == 0) {
                        int finalI = i;
                        int finalJ = j;

                        var newStates = new ArrayList<>(gameRules.possibleMoves(i, j)
                                .stream()
                                .map(move -> gameRules.generateNewMoves(currentState, move, finalI, finalJ))
                                .filter(this::checkIfStateExists)
                                .toList());

                        openStateList.addAll(newStates);
                    }
                }
            }

            closedStateList.add(currentState);
            counter++;
        }

        return false;
    }

    private boolean checkIfStateExists(int[][] state) {
        Iterator<int[][]> openStateListIterator = openStateList.iterator();
        Iterator<int[][]> closedStateListIterator = closedStateList.iterator();
        while (openStateListIterator.hasNext() || closedStateListIterator.hasNext()) {
            if (openStateListIterator.hasNext() && Arrays.deepEquals(openStateListIterator.next(), state)) {
                return false;
            }

            if (closedStateListIterator.hasNext() && Arrays.deepEquals(closedStateListIterator.next(), state)) {
                return false;
            }
        }

        return true;
    }
}
