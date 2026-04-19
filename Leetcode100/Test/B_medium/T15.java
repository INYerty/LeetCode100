package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2 ;i++){
//            int left = 0;
            int right = nums.length - 1;
            int require = -nums[i];
            int left = i + 1;

            if (i > 0 && nums[i] == nums[i - 1]) continue;



            while(left<right){
                if (nums[left] + nums[right] > require){
//                    System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                    right--;
                }else if (nums[left] + nums[right] < require) {
//                    System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                    left++;
                }else {
//                    System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);

                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        T15 t = new T15();
        t.threeSum(nums);
    }
}
