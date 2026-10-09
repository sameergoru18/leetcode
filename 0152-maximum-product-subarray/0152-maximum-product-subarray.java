class Solution {
    public int maxProduct(int[] nums) {
        int max_product = nums[0];
        int min_product=nums[0];
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            int curr = nums[i];
            if(curr<0){
                int temp = max_product;
                max_product = min_product;
                min_product = temp;
            }
            max_product = Math.max(max_product*curr,curr);
            min_product = Math.min(min_product*curr,curr);
            result=Math.max(result,max_product);
        }
        return result;

        
    }
}