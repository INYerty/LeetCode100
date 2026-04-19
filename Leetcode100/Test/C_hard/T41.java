package Test.C_hard;

import java.util.HashSet;

public class T41 {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int j = 0; j < nums.length; j++) {
            if(set.contains(j+1)){
                continue;
            }else{
                return j+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        T41 t = new T41();
        int[] nums = {100000, 3, 4000, 2, 15, 1, 99999};
        System.out.println(t.firstMissingPositive(nums));
    }
}
