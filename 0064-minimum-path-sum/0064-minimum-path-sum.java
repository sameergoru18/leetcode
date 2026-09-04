class Solution {
    public int minSum(int i,int j,int[][] dp,int[][] grid){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        if(j>0) left=minSum(i,j-1,dp,grid)+grid[i][j];
        if(i>0) up = minSum(i-1,j,dp,grid)+grid[i][j];

        dp[i][j]=Math.min(left,up);
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return minSum(m-1,n-1,dp,grid);
        
    }
}