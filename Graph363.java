public class Graph363 {
    public static int x;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        x = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        return flood(image, visited, sr, sc, newColor);
    }

    public int[][] flood(int[][] image, boolean[][] visited, int sr, int sc, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc])
            return image;

        visited[sr][sc] = true;
        if (image[sr][sc] == x)
            image[sr][sc] = newColor;
        else
            return image;

        flood(image, visited, sr - 1, sc, newColor);
        flood(image, visited, sr + 1, sc, newColor);
        flood(image, visited, sr, sc - 1, newColor);
        flood(image, visited, sr, sc + 1, newColor);

        return image;
    }
}
