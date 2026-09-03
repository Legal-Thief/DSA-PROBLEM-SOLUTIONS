class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] vis= new int[graph.length];
        for(int i =0;i<graph.length;i++){
            vis[i]=-1;
        }

        for(int i=0;i<graph.length;i++){
            if(vis[i]==-1){
                if(!dfs(i,true,vis,graph)){
                    return false;
                }
            }
        }
        return true;

    }
    public boolean dfs(int node , boolean color,int[] vis, int[][] graph){
        if(!color){
            vis[node]=1;
        }else{
            vis[node]=0;
        }
        for(int i:graph[node]){
            if(vis[i]==-1){
                if(!dfs(i,!color,vis,graph)){
                    return false;
                }
            }else if(vis[i]==vis[node]){
                return false;
            }
        }
        return true;
    }
}