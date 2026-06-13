package Test.B_medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/**
 * 207. 课程表
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。
 * 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 
 * 先学习课程 bi 。
 * * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 提示：
 * * 1 <= numCourses <= 2000
 * * 0 <= prerequisites.length <= 5000
 * * prerequisites[i].length == 2
 * * 0 <= ai, bi < numCourses
 * * prerequisites[i] 中的所有课程对 互不相同
 *
 * 链接：https://leetcode.cn/problems/course-schedule/
 */

public class T207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        // 用一个邻接表存储图
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> preLearn = new ArrayList<>();
            if (!map.containsKey(prerequisites[i][0])){ // 如果是新的节点 要新建邻接表空集合
                map.put(prerequisites[i][0], preLearn);
                preLearn.add(prerequisites[i][1]); // 向集合中添加邻接信息
            }else{
                // 如果是原先存在的节点 我们先找到它  得到它的邻接信息
                List<Integer> preLearn1 = map.get(prerequisites[i][0]);
                preLearn1.add(prerequisites[i][1]);
            }
        }
        int addToQueueSum = 0;
        // 接下来就是验证是否能完成了 我们先查找入度为零的节点 也就是preLearn是空的。
        // 遍历所有的节点 将入度为零的节点 加入到队列queue
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i) || map.get(i).isEmpty()) {
                    queue.add(i);
                    visited[i] = true;
                    addToQueueSum++;
            }
        }

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            // 队列弹出元素  继续查找有关弹出的这个节点的信息  那么如果其他节点的preLearn列表中含有poll节点  将其删除  实现入度-1
            for (int i = 0; i < prerequisites.length; i++) {
                if (map.get(prerequisites[i][0]).contains(poll)){
                    map.get(prerequisites[i][0]).remove(poll);
                }
            }
            for (int i = 0; i < prerequisites.length; i++) {
                if (map.get(prerequisites[i][0]).isEmpty()){
                    // 避免重复入队
                    if (!visited[prerequisites[i][0]]){
                        queue.add(prerequisites[i][0]);
                        visited[prerequisites[i][0]] = true;
                        addToQueueSum++;
                    }
                }
            }
        }

        return addToQueueSum == numCourses;

    }
}