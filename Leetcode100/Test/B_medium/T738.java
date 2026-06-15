package Test.B_medium;

import java.util.Arrays;

public class T738 {
    public int monotoneIncreasingDigits(int n) {
        String num = String.valueOf(n);
        char[] numsArray = num.toCharArray();
        int right = numsArray.length - 1;
        int left = right - 1;
        while (left >= 0) {
            if (numsArray[right] >= numsArray[left]) {
                right--;
                left--;
            } else {
                numsArray[left]--;
                for (int i = right; i < numsArray.length; i++) {
                    numsArray[i] = '9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(numsArray));
    }
}
