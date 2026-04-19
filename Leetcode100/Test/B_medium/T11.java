package Test.B_medium;

public class T11 {
    public static void main(String[] args) {
        T11 t = new T11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        t.maxArea(height);
    }

    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        int area = 0;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
