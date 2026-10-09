class Solution {
    public int pickup(int i,int j1,int j2,int[][] grid,int[][][] dp){
       if(i==grid.length-1){
        if(j1!=j2){
            if(j1>=0 && j1<grid[0].length && j2>=0 &&  j2<grid[0].length){
                return grid[i][j1]+grid[i][j2];
            }
            if(j1>=0 && j1<grid[0].length) return grid[i][j1];
            else if(j2>=0 && j2<grid[0].length) return grid[i][j2];
            else return 0;
            
        }
        else {
            if(j1>=0 && j1<grid[0].length ){
                return grid[i][j1];
            }
            else return 0;

        }
       }
       if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

       int max=Integer.MIN_VALUE;


        for(int k=-1;k<=1;k++){
            for(int l=-1;l<=1;l++){
                if(j1+k>=0 && j2+l>=0 && j1+k<grid[0].length && j2+l<grid[0].length){
                    int points = pickup(i+1,j1+k,j2+l,grid,dp)+grid[i][j1];
                    if(j1!=j2) points+=grid[i][j2];
                    

                   
                    max=Math.max(points,max);

                }
                
            

            }
        }
        dp[i][j1][j2]=max;
       return max;


        



    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return pickup(0,0,n-1,grid,dp);

        
    }
}