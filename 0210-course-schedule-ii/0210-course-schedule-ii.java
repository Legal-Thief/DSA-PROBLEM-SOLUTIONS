class Solution {
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int u = p[0];
            int v = p[1];

            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];

        int[] order = new int[numCourses];
        index = 0;

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCycle(adj, visited, rec, i, order)) {
                    return new int[0];
                }
            }
        }


        for (int i = 0; i < numCourses / 2; i++) {
            int temp = order[i];
            order[i] = order[numCourses - 1 - i];
            order[numCourses - 1 - i] = temp;
        }

        return order;
    }

    public boolean isCycle(
        List<List<Integer>> adj,
        boolean[] visited,
        boolean[] rec,
        int node,
        int[] order
    ) {
        visited[node] = true;
        rec[node] = true;

        for (int next : adj.get(node)) {

            if (!visited[next]) {
                if (isCycle(adj, visited, rec, next, order)) {
                    return true;
                }
            }
            else if (rec[next]) {
                return true;
            }
        }

        rec[node] = false;

        order[index++] = node;

        return false;
    }
}