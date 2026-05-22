import java.util.ArrayList;
import java.util.List;

public class T74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                list.add(matrix[i][j]);
            }
        }
        int right = list.size()-1;
        int result = 0;
        while(left<right){
            int mid = (left+right)/2;
            if (target<list.get(mid)){
                right = mid-1;
            } else if (target>list.get(mid)) {
                left = mid+1;
            }else {
                return true;
            }
        }
        return false;
    }
}
