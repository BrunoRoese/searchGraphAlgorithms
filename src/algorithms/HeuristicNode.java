package algorithms;

public class HeuristicNode {

    private int depth;
    private int[][] state;

    public HeuristicNode(int depth, int[][] state) {
        this.depth = depth;
        this.state = state;
    }

    public int getDepth() {
        return depth;
    }

    public int[][] getState() {
        return state;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setState(int[][] state) {
        this.state = state;
    }
}
