package Test.A_easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * https://leetcode.cn/problems/pascals-triangle/description/
 */
public class T118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for(int i = 1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1;j<i;j++){
                row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
