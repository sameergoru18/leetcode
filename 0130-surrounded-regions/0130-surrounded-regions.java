class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1)&& board[i][j]=='O'){
                    queue.add(new int[]{i,j});
                    visited[i][j]=1;
                }
                
            }
            
        }
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            for(int[] dir: directions){
                int ni=arr[0]+dir[0];
                int nj = arr[1]+dir[1];
                if(ni>=0 && ni<m && nj>=0 && nj<n && visited[ni][nj]==0 && board[ni][nj]=='O'){
                    
                    visited[ni][nj]=1;
                    queue.add(new int[]{ni,nj});
                }

            }
                
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }

        
    }
}