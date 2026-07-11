class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans =new ArrayList<>();
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        solve (0,n,board,ans);
        return ans ;
    }
    public void solve(int row , int n, char [][] board, List<List<String>> ans ){
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return ;
        } 
        for(int col = 0; col < n; col++){

            if(isSafe(row, col , board)){

                board[row][col] = 'Q';

                solve(row+1,n,board,ans);

                board[row][col] = '.';
            }
        }
    }
    public boolean isSafe (int row, int col , char[][] board ){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q') return false ;
        }
        for(int i = row - 1, j = col - 1;
            i >= 0 && j >= 0;
            i--, j--){

            if(board[i][j] == 'Q')
                return false;
        }
        for(int i = row - 1, j = col + 1;
            i >= 0 && j < board[0].length;
            i--, j++){

            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}