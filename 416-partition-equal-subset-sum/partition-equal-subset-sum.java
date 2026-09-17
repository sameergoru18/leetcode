class Solution {
    public boolean f(int i,int[] nums,int sum,int[][] dp){
        if(sum==0) return true;
        if(i<0){
            return (sum==0);
        }
        if(dp[i][sum]!=-1){
            return (dp[i][sum]==1);
        }

        boolean dont = f(i-1,nums,sum,dp);

        boolean take = false;
        if(nums[i]<=sum){
            take=f(i-1,nums,sum-nums[i],dp);
        }
        if(take || dont){
            dp[i][sum]=1;
        }
        else{
            dp[i][sum]=0;
        }

        return take || dont;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total=0;
        for(int x: nums){
            total+=x;
        }
        if(total%2==1){
            return false;
        }
        int[][] dp = new int[n][total+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(n-1,nums,total/2,dp);
        
    }
}