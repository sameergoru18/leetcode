class Solution {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;
        StringBuilder sb = new StringBuilder(s);
        while(left <= right){
            if(s.charAt(left)!=s.charAt(right)){
                if(Integer.valueOf(s.charAt(left))<Integer.valueOf(s.charAt(right))){
                    sb.setCharAt(right,s.charAt(left));
                }
                else{
                    sb.setCharAt(left,s.charAt(right));
                }
            }
            left++;
            right--;
        }
        return sb.toString();
        
    }
}