class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Add all 0s as starting points
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }

        // Multi-source BFS
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            
            if (r > 0 && mat[r - 1][c] == -1) {
                mat[r - 1][c] = mat[r][c] + 1;
                q.offer(new int[]{r - 1, c});
            }


            if (r < n - 1 && mat[r + 1][c] == -1) {
                mat[r + 1][c] = mat[r][c] + 1;
                q.offer(new int[]{r + 1, c});
            }

            
            if (c > 0 && mat[r][c - 1] == -1) {
                mat[r][c - 1] = mat[r][c] + 1;
                q.offer(new int[]{r, c - 1});
            }

            
            if (c < m - 1 && mat[r][c + 1] == -1) {
                mat[r][c + 1] = mat[r][c] + 1;
                q.offer(new int[]{r, c + 1});
            }
        }

        return mat;
    }
}