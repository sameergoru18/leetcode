class Solution {
    public boolean isSafe(int row,int col,char[][] board){
        int n = board.length;
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        int i=row-1;
        int j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }
        i=row-1;
        j=col+1;
        while(i>=0 && j<n){
            if(board[i][j]=='Q') return false;
            i--;
            j++;

        }
        return true;

    }
    public void   solve(int i,char[][] board,int n,List<List<String>> ans ){
        if(i==n){
            
            List<String> temp = new ArrayList<>();
            for(int r=0;r<n;r++){
                temp.add(new String(board[r]));
            }
            ans.add(temp);
            return;

        }
        for(int j=0;j<n;j++){
            if(isSafe(i,j,board)){
                board[i][j]='Q';
                solve(i+1,board,n,ans);
                board[i][j]='.';
            }
            
        }


    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>> ans = new ArrayList<>();
        solve(0,board,n,ans);
        return ans;
        
    }
}