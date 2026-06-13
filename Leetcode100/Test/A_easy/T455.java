package Test.A_easy;

import java.util.Arrays;
/**
 * 455. 分发饼干
 *
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是满足尽可能多的孩子，并输出这个最大数值。
 * 提示：
 * * 1 <= g.length <= 3 * 104
 * * 0 <= s.length <= 3 * 104
 * * 1 <= g[i], s[j] <= 231 - 1
 * 注意：本题与 2410. 运动员和训练师的最大匹配数 [https://leetcode.cn/problems/maximum-matching-o
 * f-players-with-trainers/] 题相同。
 *
 * 链接：https://leetcode.cn/problems/assign-cookies/
 */

public class T455 {
    public int findContentChildren(int[] g, int[] s) {
        int num = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length-1;
        for (int i = g.length-1; i >= 0 ; i--) {
            if(index>=0 && s[index] >= g[i]){
                num++;
                index--;
            }
        }
        return num;
    }
}