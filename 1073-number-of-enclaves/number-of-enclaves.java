class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && visited[i][j]==false && grid[i][j]==1){
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;

                }
            }
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            for(int []dir : directions){
                int i = arr[0]+dir[0];
                int j = arr[1]+dir[1];
                if(i>=0 && i<m && j>=0 && j<n && grid[i][j]==1 && visited[i][j]==false){
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;


                }
            }



        }
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    count++;
                    visited[i][j]=true;
                    
                }
            }
        }
        return count;

        
    }
}