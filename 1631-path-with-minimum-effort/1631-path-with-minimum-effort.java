class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dis = new int[n][m];

        for (int[] row : dis) {
            Arrays.fill(row, (int) 1e9);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dis[0][0] = 0;

        // {effort, row, col}
        pq.offer(new int[]{0, 0, 0});

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int effort = curr[0];
            int i = curr[1];
            int j = curr[2];

            
            if (i == n - 1 && j == m - 1) {
                return effort;
            }

            
            if (effort > dis[i][j]) {
                continue;
            }

            for (int[] dir : directions) {

                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
                    continue;
                }

                int edgeEffort =
                    Math.abs(heights[ni][nj] - heights[i][j]);

                int newEffort =
                    Math.max(effort, edgeEffort);

                if (newEffort < dis[ni][nj]) {

                    dis[ni][nj] = newEffort;

                    pq.offer(new int[]{
                        newEffort,
                        ni,
                        nj
                    });
                }
            }
        }

        return 0;
    }
}