package Test.B_medium;

import java.util.LinkedList;
/**
 * 79. 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；
 * 否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 提示：
 * * m == board.length
 * * n = board[i].length
 * * 1 <= m, n <= 6
 * * 1 <= word.length <= 15
 * * board 和 word 仅由大小写英文字母组成
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * 链接：https://leetcode.cn/problems/word-search/
 */

public class T79 {
    public boolean exist(char[][] board, String word) {
        /*// 将wordToCharArray之后入栈，每找到一个元素pop 并标记visited二维数组为true。每一行的元素
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
        return false;*/
        boolean[][] visited = new boolean[board.length][board[0].length];

        LinkedList<Character> queue = new LinkedList<>();
        char[] charArray = word.toCharArray();
        for(char i :charArray){
            queue.add(i);
        }

        // 寻找起始点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!queue.isEmpty()){
                    Character peek = queue.peek();
                    if(board[i][j] == peek){
                        visited[i][j] = true;
                        queue.pop();
                        if (backTrace(board,visited,queue,i,j)) return true;
                        visited[i][j] = false;
                        queue.addFirst(peek);
                    }
                }
            }
        }
        return false;


    }

    /*//四方向
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
    }*/

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean backTrace(char[][] board,boolean[][] visited,LinkedList<Character> queue,int x,int y){
        if (queue.isEmpty()) return true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            // 判断越界 + visited 判断 + 不等值判断
            if (newX<0 || newY<0 || newX>=board.length || newY>=board[0].length || visited[newX][newY] || board[newX][newY] != queue.peek()) continue;
            visited[newX][newY] = true;
            Character poll = queue.poll();
            if (backTrace(board,visited,queue,newX,newY)) return true;
            visited[newX][newY] = false;
            queue.addFirst(poll);
        }

        return false;
    }
}