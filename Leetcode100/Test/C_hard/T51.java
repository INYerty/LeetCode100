package Test.C_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        // 初始化棋盘
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');
        }
        backTrace(chessBoard,n,0);
        return result;
    }

    List<List<String>> result = new ArrayList<>();


    public void backTrace(char[][] chessBoard,int n,int row){
        if (row == n){
            result.add(fix(chessBoard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row,i,n,chessBoard)){
                chessBoard[row][i] = 'Q';
                backTrace(chessBoard,n,i+1);
                chessBoard[row][i] ='.';
            }
        }
    }

    private List<String> fix(char[][] chessBoard) {
        ArrayList<String> list = new ArrayList<>();
        for (char[] i:chessBoard){
            String s = String.copyValueOf(i);
            list.add(s);
        }
        return list;
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

}
