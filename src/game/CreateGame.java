package game;

public class CreateGame {

    private final int[][] initialState;
    private final int[][] goalState;

    public CreateGame() {
        this.initialState = new int[][]{
                {1, 2, 3},
                {4, 0, 6},
                {7, 5, 8}};
        this.goalState = new int[][]{
                {1, 2, 3},
                {8, 0, 4},
                {7, 6, 5}
        };
    }

    public int[][] getInitialState() {
        return initialState;
    }

    public int[][] getGoalState() {
        return goalState;
    }
}
