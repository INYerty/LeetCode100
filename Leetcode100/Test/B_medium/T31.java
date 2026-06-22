package Test.B_medium;

import java.util.Arrays;

//TODO ： 做不出来了 改天做
public class T31 {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length-1;i>=1;i--){
            if(nums[i] >= nums[i-1]){
                swap(nums,i,i-1);

            }
        }
        Arrays.sort(nums);

    }
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
