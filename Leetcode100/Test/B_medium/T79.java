package Test.B_medium;

import java.util.LinkedList;

public class T79 {
    public boolean exist(char[][] board, String word) {
        // 将wordToCharArray之后入栈，每找到一个元素pop 并标记visited二维数组为true。每一行的元素
        char[] charArray = word.toCharArray();
        LinkedList<Character> queue = new LinkedList<>();
        for(char i:charArray){
            queue.add(i);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 起点字符必须匹配第一个
                if (board[i][j] == queue.peekFirst()) {
                    visited[i][j] = true;
                    queue.poll(); // 消耗第一个字符
                    if (backTrace(board, queue, visited, i, j)) return true;
                    queue.addFirst(word.charAt(0)); // 回溯还原
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    //四方向
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean backTrace(char[][] board,LinkedList<Character> queue,boolean[][] visited,int x,int y){
        if (queue.isEmpty()){
            return true;
        }
        Character peek = queue.peek();
        for (int i = 0; i < 4; i++) {
            int newX = x+dirs[i][0];
            int newY = y+dirs[i][1];
            if (newX<0||newY<0||newX>=board.length||newY>=board[0].length||visited[newX][newY]||board[newX][newY]!=peek){
                continue;
            }
            if (board[newX][newY]==peek){
                visited[newX][newY] = true;
                queue.pop();
                if (backTrace(board, queue, visited, newX, newY)) return true;
                visited[newX][newY] = false;
                queue.addFirst(peek);
            }
        }
        return false;
    }
}
