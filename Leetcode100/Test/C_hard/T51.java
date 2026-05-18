package Test.C_hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for(char[] i : chessboard){
            Arrays.fill(i,'.');
        }
        backTrace(n,0,chessboard);
        return result;
    }

    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    /**
     * 回溯
     * @param n 同一行中，第n个元素
     * @param row 行数
     * @param chessboard 棋盘
     */
    public void backTrace(int n,int row,char[][] chessboard){
        if (row == n){
            result.add(fix(chessboard));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isValid(row,i,n,chessboard)){
                chessboard[row][i] = 'Q';
                backTrace(n,row+1,chessboard);
                chessboard[row][i] = '.';
            }
        }
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> fix(char[][] chessboard){
        ArrayList<String> list = new ArrayList<>();
        for(char[] i : chessboard){
            list.add(String.copyValueOf(i));
        }
        return list;
    }


}
