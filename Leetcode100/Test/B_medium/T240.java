package Test.B_medium;

public class T240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;//左右长度
        int n = matrix.length;//上下长度
        for (int i = 0; i < n; i++) {
            int lenMax = matrix[i][m-1];
            if(target>lenMax){
                continue;
            }else{
                for(int j = 0 ; j<= m-1;j++){
                    if (target == matrix[i][j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T240 t = new T240();
        boolean b = t.searchMatrix(new int[][]{{-5}}, -5);
        System.out.println(b);
    }
}
