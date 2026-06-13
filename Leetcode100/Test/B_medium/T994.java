package Test.B_medium;

import java.util.LinkedList;
/**
 * 994. 腐烂的橘子
 *
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * * 值 0 代表空单元格；
 * * 值 1 代表新鲜橘子；
 * * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * 提示：
 * * m == grid.length
 * * n == grid[i].length
 * * 1 <= m, n <= 10
 * * grid[i][j] 仅为 0、1 或 2
 *
 * 链接：https://leetcode.cn/problems/rotting-oranges/
 */

public class T994 {
    //多源dfs
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        int minute = 0;
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    ++fresh;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        while (!queue.isEmpty() && fresh != 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = poll[0] + dir[j][0];
                    int newY = poll[1] + dir[j][1];
                    if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] != 1)
                        continue;
                    if (grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        --fresh;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            ++minute;
        }

        return fresh!=0?-1:minute;
    }


    /*public int orangesRotting(int[][] grid) {
        int minute = 0;
        int fresh = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    ++fresh;
                }else if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty() && fresh!= 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = poll[0] + dir[j][0];
                    int newY = poll[1] + dir[j][1];
                    if (newX<0||newY<0||newX>=grid.length||newY>=grid[0].length) continue;
                    if (grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        queue.add(new int[]{newX,newY});
                        --fresh;
                    }
                }
            }
            ++minute;
        }
        if (fresh > 0){
            return -1;
        }else{
            return minute;
        }
    }*/

}