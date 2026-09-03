class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int j = 0; j < m; j++) {

            if (grid[0][j] == 1 && !visited[0][j]) {
                q.offer(new int[] { 0, j });
                visited[0][j] = true;
            }

            if (grid[n - 1][j] == 1 && !visited[n - 1][j]) {
                q.offer(new int[] { n - 1, j });
                visited[n - 1][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {

            if (grid[i][0] == 1 && !visited[i][0]) {
                q.offer(new int[] { i, 0 });
                visited[i][0] = true;
            }

            if (grid[i][m - 1] == 1 && !visited[i][m - 1]) {
                q.offer(new int[] { i, m - 1 });
                visited[i][m - 1] = true;
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            if (r - 1 >= 0 && grid[r - 1][c] == 1 && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                q.offer(new int[] { r - 1, c });
            }

            if (r + 1 < n && grid[r + 1][c] == 1 && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                q.offer(new int[] { r + 1, c });
            }

            if (c - 1 >= 0 && grid[r][c - 1] == 1 && !visited[r][c - 1]) {
                visited[r][c - 1] = true;
                q.offer(new int[] { r, c - 1 });
            }

            if (c + 1 < m && grid[r][c + 1] == 1 && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                q.offer(new int[] { r, c + 1 });
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    cnt++;
                }
            }
        }

        return cnt;

    }
}