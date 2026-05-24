package Test.B_medium;

public class T153 {
    public int findMin(int[] nums){
        int left = 0,right = nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if (nums[left]<=nums[mid] && nums[mid]<=nums[right]) return nums[left];
            if(nums[left]<=nums[mid]){
                left = mid + 1;
            }else{
                right = mid;// 为什么不是mid-1不是mid, 最小值一定是存在于第二个递增区间中的  所以mid可能是最小值
            }
        }
        return -1;
    }
}
