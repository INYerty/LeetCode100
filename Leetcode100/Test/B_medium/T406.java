package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 406. 根据身高重建队列
 *
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。
 * 返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的
 * 人）。
 * 提示：
 * * 1 <= people.length <= 2000
 * * 0 <= hi <= 106
 * * 0 <= ki < people.length
 * * 题目数据确保队列可以被重建
 *
 * 链接：https://leetcode.cn/problems/queue-reconstruction-by-height/
 */

public class T406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0]; // 身高降序
            } else {
                return a[1] - b[1]; // k 值升序
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] i : people){
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}