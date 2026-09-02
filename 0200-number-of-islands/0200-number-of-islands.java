class Solution {
    public void bsf(int row, int col, int[][] vis, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col });
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };

            for (int k = 0; k < 4; k++) {

                int newr = r + dr[k];
                int newc = c + dc[k];

                if (newr >= 0 && newr < n &&
                        newc >= 0 && newc < m &&
                        vis[newr][newc] == 0 &&
                        grid[newr][newc] == '1') {

                    vis[newr][newc] = 1;
                    q.add(new int[] { newr, newc });
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    bsf(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }
}