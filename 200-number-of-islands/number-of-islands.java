class Solution {
    public void dfs(int i,int j,char[][] grid,boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j]=true;
        int[][] directions={{0,-1},{0,1},{1,0},{-1,0}};
        for(int[] dir: directions){
            int ni = i+dir[0];
            int  nj = j+dir[1];
            if((ni<m && ni>=0 && nj<n && nj>=0)&& grid[ni][nj]=='1' && visited[ni][nj]==false){
                dfs(ni,nj,grid,visited);
            }
        }

        
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    dfs(i,j,grid,visited);
                    count++;

                }

            }
        }
        return count;
        
    }
}