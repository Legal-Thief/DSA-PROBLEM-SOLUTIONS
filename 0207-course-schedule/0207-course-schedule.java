class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, path)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(
            List<List<Integer>> adj,
            int node,
            boolean[] visited,
            boolean[] path) {
        visited[node] = true;
        path[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(adj, neighbor, visited, path)) {
                    return true;
                }
            } else if (path[neighbor]) {
                return true;
            }
        }

        path[node] = false;

        return false;
    }
}