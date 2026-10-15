class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int sum=0;
        for(int i=0;i<1;i++){
            for(int j=0;j<n;j++){
               dp[i][j]=matrix[i][j];
                sum+=dp[i][j];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<1;j++){
               dp[i][j]=matrix[i][j];
                sum+=dp[i][j];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==1){
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
                else{
                    dp[i][j]=0;
                }
                sum+=dp[i][j];
            }
        }
        return sum;
      
        

        
    }
}