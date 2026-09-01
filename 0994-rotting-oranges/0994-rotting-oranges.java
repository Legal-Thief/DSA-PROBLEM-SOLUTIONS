class Solution {
    class Pair {
        int row;
        int col;
        int time;

        Pair(int time, int row, int col) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int freshOranges= 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(0,i,j));
                }else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        int[][] directions = {
            {-1,0},
            {0,-1},
            {1,0},
            {0,1}
        };

        int time=0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            time = Math.max(time, curr.time);
            for(int[] dir:directions){
                int newRow= curr.row + dir[0];
                int newCol = curr.col + dir[1];
                if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]==1){
                    grid[newRow][newCol]=2;
                    freshOranges--;
                    q.offer(new Pair(curr.time+1,newRow,newCol));
                } 
            }
        }

        return freshOranges==0? time:-1;
    }
}