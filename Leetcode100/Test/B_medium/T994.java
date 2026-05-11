package Test.B_medium;

import java.util.LinkedList;

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
