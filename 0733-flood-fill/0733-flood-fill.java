class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int row, int col,
                     int originalColor, int color) {

      
        image[row][col] = color;

        int[][] directions = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
        };

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < image.length &&
                newCol >= 0 && newCol < image[0].length &&
                image[newRow][newCol] == originalColor) {

                dfs(image, newRow, newCol, originalColor, color);
            }
        }
    }
}