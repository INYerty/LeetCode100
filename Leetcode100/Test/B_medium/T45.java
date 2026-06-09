package Test.B_medium;

public class T45 {
    public int jump(int[] nums) {
        int right_site = 0;
        int cur = 0;
        int count = 0;
        if(nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] + i > right_site){
                right_site = nums[i] + i;
            }

            if(right_site >= nums.length-1){
                count++;
                break;
            }

            if(i == cur){
                cur = right_site;
                count++;
            }
        }
        return count;
    }
}
