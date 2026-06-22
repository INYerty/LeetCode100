package Test.week.week507;
/**
 * 3968. 移动后的最大曼哈顿距离
 * 已解答
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由字符 'U'、'D'、'L'、'R' 和 '_' 组成的字符串 moves。
 *
 * 从原点 (0, 0) 出发，每个字符表示二维平面上的一次移动：
 *
 * 'U'：向上移动 1 个单位。
 * 'D'：向下移动 1 个单位。
 * 'L'：向左移动 1 个单位。
 * 'R'：向右移动 1 个单位。
 * '_'：可以独立地替换为 'U'、'D'、'L' 或 'R' 中的任意一个字符。
 * 返回执行完所有移动后，能够达到的距离原点的 最大曼哈顿距离 。
 *
 * 两点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 |x1 - x2| + |y1 - y2|。
 *
 * https://leetcode.cn/problems/maximum-manhattan-distance-after-all-moves/description/
 */
public class T3968 {
    public int maxDistance(String moves) {
        int u = 0, d = 0, l = 0, r = 0, wild = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U')
                u++;
            else if (c == 'D')
                d++;
            else if (c == 'L')
                l++;
            else if (c == 'R')
                r++;
            else if (c == '_')
                wild++;
        }
        return Math.abs(r - l) + Math.abs(u - d) + wild;
    }
}
