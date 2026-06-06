package Test.B_medium;

import java.util.ArrayList;

public class T376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1)
            return 1;
        if (nums.length == 2) {
            if (nums[0] != nums[1]) {
                return 2;
            }else{
                return 1;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            int j = i+1;
            if(nums[i] == nums[j]) {
                continue;
            }
            list.add(nums[j] - nums[i]);
        }
        int[] sub = list.stream().mapToInt(Integer::intValue).toArray();
        int count = 0;
        for (int i = 0; i < sub.length-1; i++) {
            if(sub[i] > 0 && sub[i+1] < 0){
                count++;
            } else if (sub[i] < 0 && sub[i + 1] > 0) {
                count++;
            }else{

            }
        }
        return count+2;
    }


    public static void main(String[] args) {
        T376 t376 = new T376();
        int[] arr = new int[]{0,0,0};
        int i = t376.wiggleMaxLength(arr);
        System.out.println(i);
    }
}
