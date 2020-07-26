package practice.week3;

public class Day7_WordSearch {
    public boolean exist(char[][] board, String word) {

        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]==word.charAt(0)&& dfs(0 ,row,col,board, word))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(int count,int row,int col,char[][] board,String word){
        if(count==word.length())
            return true;

        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!=word.charAt(count))
            return false;

        char temp=board[row][col];
        board[row][col]=' ';

        boolean found=dfs(count+1 ,row-1,col,board, word)||dfs(count+1 ,row+1,col,board, word)||dfs(count+1 ,row,col-1,board, word)||dfs(count+1 ,row,col+1,board, word);

        board[row][col]=temp;

        return found;
    }
}
