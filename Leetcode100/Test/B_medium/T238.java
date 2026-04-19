package Test.B_medium;

public class T238 {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int[] res = new int[nums.length];
         //计算左区间的积
        for (int i = 0; i < nums.length; i++) {
            //这里计算的是每一个nums[i]所对应的左区间的积
            if (i > 0) {
                left *= nums[i - 1];
            }
            //这里直接记录到结果res数组中
            res[i] = left;
        }
        //下面开始计算右面区间的积
        for (int i = nums.length - 1; i >= 0; i--) {
            //这里计算的是每一个nums[i]所对应的右区间的积
            if (i < nums.length - 1) {
                right *= nums[i + 1];
            }
            //这里直接乘到结果res数组中
            res[i] *= right;
        }
        return res;
    }


    public static void main(String[] args) {
        T238 t = new T238();
        int[] nums = {1, 2, 3, 4};
        for (int i : t.productExceptSelf(nums))
            System.out.print(i + " ");
        t.productExceptSelf(nums);

    }
}
