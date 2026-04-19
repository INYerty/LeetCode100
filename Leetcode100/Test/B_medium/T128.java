package Test.B_medium;

import java.util.Arrays;

public class T128 {
    public static void main(String[] args) {
        int[] nums = {100,6,7,8,4,200,1,3,2};
        T128 t = new T128();
        t.longestConsecutive(nums);
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int maxLen = 1;
        int currentLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue; // 去重
            } else if (nums[i] == nums[i - 1] + 1) {
                currentLen++;
            } else {
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 1;
            }

        }
        System.out.println(maxLen);
        return Math.max(maxLen, currentLen);

    }
}
