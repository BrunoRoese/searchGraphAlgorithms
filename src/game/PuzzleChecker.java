package game;

public class PuzzleChecker {
    public boolean isSolvable(int[][] puzzle) {
        int inversions = 0;
        int[] flatPuzzle = flattenPuzzle(puzzle);

        for (int i = 0; i < flatPuzzle.length - 1; i++) {
            for (int j = i + 1; j < flatPuzzle.length; j++) {
                if (flatPuzzle[i] != 0 && flatPuzzle[j] != 0 && flatPuzzle[i] > flatPuzzle[j]) {
                    inversions++;
                }
            }
        }

        return inversions % 2 == 0;
    }

    private int[] flattenPuzzle(int[][] puzzle) {
        int[] flatPuzzle = new int[puzzle.length * puzzle[0].length];
        int index = 0;

        for (int[] row : puzzle) {
            for (int cell : row) {
                flatPuzzle[index++] = cell;
            }
        }

        return flatPuzzle;
    }
}
