import java.util.LinkedList;
import java.util.Queue;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] grid = new int[r][c];
        if (mat.length * mat[0].length != grid.length * grid[0].length)
            return mat;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                q.add(mat[i][j]);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = q.poll();
            }
        }
        return grid;
    }
}
