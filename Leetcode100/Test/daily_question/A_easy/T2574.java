package Test.daily_question.A_easy;

import java.util.Arrays;

public class T2574 {
    public int[] leftRightDifference(int[] nums) {
        int left_sum = 0;
        int[] left_array = new int[nums.length];
        left_array[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            left_array[i + 1] = left_sum + nums[i];
            left_sum += nums[i];
        }
        System.out.println(Arrays.toString(left_array));

        int right_sum = 0;
        int[] right_array = new int[nums.length];
        right_array[nums.length - 1] = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            right_array[i - 1] = right_sum + nums[i];
            right_sum += nums[i];
        }
        System.out.println(Arrays.toString(right_array));

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = Math.abs(left_array[i] - right_array[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        T2574 t2574 = new T2574();
        int[] arr = {10, 4, 8, 3};
        int[] ints = t2574.leftRightDifference(arr);
        for(int i:ints){
            System.out.print(i+" ");
        }
    }
}
