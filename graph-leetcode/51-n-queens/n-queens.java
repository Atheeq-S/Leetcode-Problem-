class Solution {
    List<List<String>> result=new ArrayList<>(); 
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(0,board,n);//row,board,toal quene to place;
        return result;
    }

    public void solve(int row,char[][] board,int n){


        if(row == n){
            
            List<String> temp = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            result.add(temp);
            return;
        }
        
        for(int col=0;col<n;col++){
            if(isSafe(row,col, board))
            {
                board[row][col]='Q';
                solve(row+1,board,n);
                board[row][col]='.';
            }
        }

        
    }

    public boolean isSafe(int row, int col,char[][] board){

        for(int i=0;i<row;i++){
            if(board[i][col]=='Q')
            return false;

        }

        for(int i=row,j=col;j>=0 && i>=0;j--,i--){
            if(board[i][j]=='Q')
            return false;
        }
        for(int i=row,j=col;i>=0 && j<board[0].length; i--,j++)
        {
            if(board[i][j]=='Q')
            return false;

        }

        return true;
        

    }


}