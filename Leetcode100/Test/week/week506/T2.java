package Test.week.week506;

import java.util.HashMap;
import java.util.Map;

//TODO : 不是人！
public class T2 {
    public int maxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            int[] freqCount = new int[n + 1];
            int maxFreq = 0;
            int uniqueElements = 0;

            for (int j = i; j < n; j++) {
                int val = nums[j];
                int oldFreq = freqMap.getOrDefault(val, 0);
                int newFreq = oldFreq + 1;
                freqMap.put(val, newFreq);

                if (oldFreq == 0) {
                    uniqueElements++;
                } else {
                    freqCount[oldFreq]--;
                }
                freqCount[newFreq]++;

                if (newFreq > maxFreq) {
                    maxFreq = newFreq;
                }

                int currLen = j - i + 1;
                if (currLen <= maxLen) {
                    continue;
                }

                int maxFreqNumCount = freqCount[maxFreq];

                if (maxFreqNumCount == uniqueElements) {
                    maxLen = Math.max(maxLen, currLen);
                } else if (maxFreq % 2 == 0) {
                    int targetOtherFreq = maxFreq / 2;
                    int otherFreqNumCount = freqCount[targetOtherFreq];

                    if (maxFreqNumCount + otherFreqNumCount == uniqueElements) {
                        maxLen = Math.max(maxLen, currLen);
                    }
                }
            }
        }

        return maxLen;
    }
}
