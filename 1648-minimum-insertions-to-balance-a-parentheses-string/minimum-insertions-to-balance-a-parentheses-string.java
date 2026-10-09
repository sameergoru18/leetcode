class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int i=0;
        int result=0;
        Stack<Character> stack = new Stack<>();
        while(i<n){
            char c = s.charAt(i);
            if(c=='('){
                stack.push('(');
                i++;
            }
            else{
                if(i+1<n && s.charAt(i+1)==')'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else{
                        result++;
                    }
                    i+=2;
                }
                else{
                    result++;
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else{
                        result++;
                    }
                    i+=1;
                }

            }

        }
        while(!stack.isEmpty()){
            result+=2;
            stack.pop();
        }
        return result;
        
    }
}