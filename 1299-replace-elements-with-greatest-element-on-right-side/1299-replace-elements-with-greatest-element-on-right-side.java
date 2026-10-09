class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int highest=-1;
        for(int i=n-1;i>=0;i--){
            int curr=arr[i];
            arr[i]=highest;
            highest=Math.max(curr,highest);
        }
        return arr;
    }
}