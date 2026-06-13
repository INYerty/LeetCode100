package Test.B_medium;

import java.util.LinkedList;
/**
 * 200. 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 提示：
 * * m == grid.length
 * * n == grid[i].length
 * * 1 <= m, n <= 300
 * * grid[i][j] 的值为 '0' 或 '1'
 *
 * 链接：https://leetcode.cn/problems/number-of-islands/
 */

public class T200 {
/*
// 深搜dfs
public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][]visited =new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) { // 找到了一个新的岛
                    ans++;
                    visited[i][j] = true;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return ans;
    }
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int newX = x+dir[i][0];
            int newY = y+dir[i][1];
            // 如果碰壁,continue
            if (newX<0||newY<0||newX>=grid.length||newY>=grid[0].length){
                continue;
            }
            if (grid[newX][newY] == '1'&& !visited[newX][newY]){
                visited[newX][newY] = true;
                dfs(grid,visited,newX,newY);
            }
        }
    }*/

    //广搜bfs
    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                    ans++;
                    visited[i][j] = true;
                    bfs(grid,i,j,visited);
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid,int x,int y,boolean[][] visited){
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = poll[0] + dir[i][0];
                int newY = poll[1] + dir[i][1];
                // 判断是否越界
                if (newX<0||newY<0||newX>=grid.length||newY>=grid[0].length){
                    continue;
                }
                if (grid[newX][newY] == '1' && !visited[newX][newY]){
                    char c = grid[newX][newY];
                    queue.add(new int[]{newX,newY});
                    visited[newX][newY] = true;
                }
            }
        }



    }



    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        T200 t200 = new T200();
        int islands = t200.numIslands(grid);
        System.out.println(islands);
    }
}




/* 方法一
package Test.B_medium;

public class T200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') { // 找到了一个新的岛
                    dfs(grid, i, j); // 把这个岛插满旗子，这样后面遍历到的 '1' 一定是新的岛
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 出界，或者不是 '1'，就不再往下递归
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2'; // 插旗！避免来回横跳无限递归
        dfs(grid, i, j - 1); // 往左走
        dfs(grid, i, j + 1); // 往右走
        dfs(grid, i - 1, j); // 往上走
        dfs(grid, i + 1, j); // 往下走
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        T200 t200 = new T200();
        int islands = t200.numIslands(grid);
        System.out.println(islands);
    }
}*/