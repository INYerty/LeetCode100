package Test.B_medium;

public class T153 {
    public int findMin(int[] nums){
        int left = 0,right = nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            //如果旋转了nums长度次，那么本事就是有序的  返回left即可
            if (nums[left]<=nums[mid] && nums[mid]<=nums[right]) return nums[left];
            if(nums[left]<=nums[mid]){
                // 第一个区间
                left = mid + 1;
            }else{
                // 为什么不是mid-1不是mid, 最小值一定是存在于第二个递增区间中的 mid在第二个递增区间 所以mid可能是最小值
                right = mid;
            }
        }
        return -1;
    }
}
