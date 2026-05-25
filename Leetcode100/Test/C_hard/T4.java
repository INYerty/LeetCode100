package Test.C_hard;

public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m  = nums1.length;
        int n = nums2.length;
        // 如果第二个数组的长度小于第一个数组
        if (m>n){
            // 保证m<=n
            return findMedianSortedArrays(nums2,nums1);
        }
        //初始化i的区间，i最小值是0最大值是m
        int iMin = 0,iMax = m;
        while(iMin<=iMax){
            int i = (iMin+iMax)/2; // 猜数字游戏，每次都取中间的数
            int j = (m+n+1)/2 - i; // i+j = (m+n+1)/2;i是左部分num1+num2的个数 j是右部分的个数
            // 交叉比较
            if (j!=0 && i!=m && nums2[j-1]>nums1[i]){
                iMin = i+1;
            }else if (i!=0 && j!=n && nums1[i-1]>nums2[j]){
                iMax = i-1;
            }else{
                // 找到了合适的切割位置i
                int maxLeft = 0;
                if (i == 0){
                    // 左上没有元素，最大值一定在左下
                    maxLeft = nums2[j-1];
                }else if (j==0){
                    //左下没有元素，最大值一定在左上
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                //判断数组的长度是否是奇数 如果是 直接返回中位数 即左边最大数
                if ((m+n)%2==1){
                    return maxLeft;
                }
                int minRight = 0;
                //如果是偶数 取左最大 与右最小的和 除2
                if (i==m){
                    // 右上没有数
                    minRight = nums2[j];
                } else if (j==n) {
                    minRight = nums1[i];
                }else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }
}
