package Test.A_easy;

import java.util.ArrayList;
import java.util.List;

public class T283 {
    public void moveZeroes(int[] nums) {
//        int zeroNum = 0;
//        for(int i = 0 ; i< nums.length;i++){
//            if(nums[i]==0){
//                zeroNum++;
//            }
//        }
//        for(int k =0 ;k<zeroNum;k++){
//            for(int j = 0; j < nums.length; j++){
//                for(int i =j+1;i< nums.length;i++){
//                    if(nums[j] == 0){
//                        int temp = nums[i];
//                        nums[i] = nums[j];
//                        nums[j] = temp;
//                        break;
//                    }
//                }
//            }
//        }
        List<Integer> list = new ArrayList<>();

        // 删除0（只保留非0）
        for (int num : nums) {
            if (num != 0) {
                list.add(num);
            }
        }

        // 补0
        while (list.size() < nums.length) {
            list.add(0);
        }

        // 写回原数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        T283 t = new T283();
        t.moveZeroes(nums);
    }
}
