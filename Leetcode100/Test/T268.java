package Test;

import java.util.HashSet;

public class T268 {
    public int missingNumber(int[] nums) {
        HashSet<Integer> integers = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            integers.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(i)){
                continue;
            }else{
                return i;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        T268 t = new T268();
        int[] nums = {0, 1, 3};
        System.out.println(t.missingNumber(nums));
    }
}
