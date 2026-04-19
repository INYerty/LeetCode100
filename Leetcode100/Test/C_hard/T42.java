package Test.C_hard;
public class T42 {
    public static void main(String[] args) {
        int[] height = {2,1,0,2};
        T42 t = new T42();
        t.trap(height);
    }

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int rainSum = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    rainSum += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    rainSum += rightMax - height[right];
                }
                right--;
            }
        }

//        System.out.println(rainSum);
        return rainSum;
    }
}