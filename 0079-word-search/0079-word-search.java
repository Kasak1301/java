class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
              if(board[i][j]==word.charAt(0)){
                if(dfs(i, j, 0, board, word)){
                    return true;
                }
              } 
            }
        }
        return false ;
    }
    public boolean dfs (int row , int column , int index , char[][] board , String word ){
        if(index == word.length()){
            return true ;
        }
        if(row>=board.length || row <0 ){
            return false;
        }
        if(column>=board[0].length || column<0){
            return false;
        }
        if(board[row][column] != word.charAt(index)) return false ;

        char temp = board[row][column] ;
        board[row][column] = '#'; 
        boolean down = dfs(row+1 , column , index+1 , board , word );

        boolean up = dfs(row-1 , column , index+1 , board , word);

        boolean left = dfs(row , column-1 , index+1 , board , word);

        boolean right = dfs(row , column +1 , index+1 , board , word);

        board[row][column] = temp ;
        return down || up || left || right;
    }
}