package Test.B_medium;

//TODO: 560. 和为 K 的子数组
public class T560 {

    public int subarraySum(int[] nums, int k) {
        int p = 0;
        int sum = 0;
        int count = 0;
        while(p<nums.length){
            sum += nums[p];
            if(sum<k){
                p++;
            }else if(sum>k){
                sum -= nums[p-1];
                if(nums[p]==k){
                    count++;
                }
            }else{
                count++;
                sum-= nums[p-1];
                p++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        T560 t = new T560();
        int[] nums = {1, 2,3};
        int k = 3;
        System.out.println(t.subarraySum(nums, k));
    }
}
