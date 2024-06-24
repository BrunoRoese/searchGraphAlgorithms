package algorithms;

import game.GameRules;
import game.PossibleMoves;

import java.util.*;

public class GreedyBestSearchFirstFactory implements SearchAlgorithm {

    private final PriorityQueue<HeuristicNode> priorityQueue = new PriorityQueue<HeuristicNode>((node1, node2) -> calculateHeuristic(node1) - calculateHeuristic(node2));
    private final LinkedList<int[][]> closedList = new LinkedList<>();
    private final int[][] initialState;
    private final int[][] goalState;
    private final GameRules gameRules;

    public GreedyBestSearchFirstFactory(int[][] initialState, int[][] goalState, GameRules gameRules) {
        this.initialState = initialState;
        this.goalState = goalState;
        this.gameRules = gameRules;
    }

    @Override
    public boolean execute() {
        int counter = 0;
        var firstNode = new HeuristicNode(0, initialState);
        priorityQueue.add(firstNode);

        while(!priorityQueue.isEmpty()) {
            var currentNode = priorityQueue.poll();

            if (Arrays.deepEquals(currentNode.getState(), goalState)) {
                System.out.println(counter);
                return true;
            }

            for (int i = 0; i < currentNode.getState().length; i++) {
                for (int j = 0; j < currentNode.getState()[i].length; j++) {
                    if (currentNode.getState()[i][j] == 0) {
                        int finalI = i;
                        int finalJ = j;

                        var newStates = gameRules.possibleMoves(i, j)
                                .stream()
                                .map(move -> gameRules.generateNewMoves(currentNode.getState(), move, finalI, finalJ))
                                .filter(this::checkIfStateExists)
                                .map(state -> new HeuristicNode(currentNode.getDepth() + 1, state))
                                .toList();

                        priorityQueue.addAll(newStates);
                    }
                }
            }

            closedList.add(currentNode.getState());
            counter++;
        }

        return false;
    }

    private boolean checkIfStateExists(int[][] state) {
        Iterator<HeuristicNode> openStateListIterator = priorityQueue.iterator();
        Iterator<int[][]> closedStateListIterator = closedList.iterator();
        while (openStateListIterator.hasNext() || closedStateListIterator.hasNext()) {
            if (openStateListIterator.hasNext() && Arrays.deepEquals(openStateListIterator.next().getState(), state)) {
                return false;
            }

            if (closedStateListIterator.hasNext() && Arrays.deepEquals(closedStateListIterator.next(), state)) {
                return false;
            }
        }

        return true;
    }

    private int calculateHeuristic(HeuristicNode node) {
        var heuristic = 0;

        for (int i = 0; i < node.getState().length; i++) {
            for (int j = 0; j < node.getState()[i].length; j++) {
                if (node.getState()[i][j] != goalState[i][j]) {
                    heuristic++;
                }
            }
        }

        return heuristic;
    }
}
