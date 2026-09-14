class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] visited = new int[m][n];
        int[][] distance = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    distance[i][j]=0;
                    visited[i][j]=1;
                }
            }
        }
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int i=arr[0];
            int j = arr[1];
            for(int[] dir: directions){
                int ni=i+dir[0];
                int nj=j+dir[1];
                if(ni>=0 && ni<m && nj>=0 && nj<n && mat[ni][nj]==1 && visited[ni][nj]==0){
                    distance[ni][nj]=distance[i][j]+1;
                    visited[ni][nj]=1;
                    q.add(new int[]{ni,nj});

                }
            }

        }
        return distance;
        
    }
}