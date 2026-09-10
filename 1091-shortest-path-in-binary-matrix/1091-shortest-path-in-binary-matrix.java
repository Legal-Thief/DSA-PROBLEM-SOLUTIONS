class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});

        grid[0][0] = 1;

        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];

            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            for (int i = 0; i < 8; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0) {

                    grid[nr][nc] = 1;

                    q.offer(new int[]{
                        nr,
                        nc,
                        dist + 1
                    });
                }
            }
        }

        return -1;
    }
}