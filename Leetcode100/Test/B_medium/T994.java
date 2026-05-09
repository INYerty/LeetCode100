package Test.B_medium;

public class T994 {
    //多源dfs
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        boolean[][] rot = new boolean[grid.length][grid[0].length];
        int minute = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2 && !rot[i][j]){// 如果是新腐烂的橘子
                    rot[i][j] = true;
                    dfs(grid,rot,i,j);
                }
            }
        }
    }

    public int dfs(int[][] grid,boolean[][] rot,int x,int y){

    }


}
