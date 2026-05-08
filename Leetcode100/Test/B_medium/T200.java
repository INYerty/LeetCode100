package Test.B_medium;

public class T200 {
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
