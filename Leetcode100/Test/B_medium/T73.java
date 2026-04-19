package Test.B_medium;

public class T73 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[] zeroRow = new boolean[row];
        boolean[] zeroColumn = new boolean[column];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
                if(matrix[i][j] == 0){
                    zeroRow[i] = true;
                    zeroColumn[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
                if(zeroRow[i] || zeroColumn[j]){
                    matrix[i][j] = 0;
                }
            }
        }


    }

    public static void main(String[] args) {
        T73 t = new T73();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        t.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
