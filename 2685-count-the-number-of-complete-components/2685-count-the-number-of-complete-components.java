class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int cc = 0;
        for(int i =0;i<n;i++){
            if(!visited[i]){
                int[] count= new int[2];
                dfs(i,visited,adj ,count);
                int node = count[0];
                int edge = count[1]/2;
                if(edge==(node * (node - 1)) / 2){
                    cc++;
                }
            }

        }
        return cc;
    }
    public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>>adj,int[] count){
        visited[node] = true;
        count[0]++;
        count[1]+= adj.get(node).size();
        for(int i: adj.get(node)){
            if(!visited[i]){
            dfs(i,visited,adj,count);}
        }
    }
}