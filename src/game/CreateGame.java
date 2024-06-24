package game;

public class CreateGame {

    private final int[][] initialState;
    private final int[][] goalState;

    public CreateGame() {
        this.initialState = new int[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        this.goalState = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
    }

    public int[][] getInitialState() {
        return initialState;
    }

    public int[][] getGoalState() {
        return goalState;
    }
}
