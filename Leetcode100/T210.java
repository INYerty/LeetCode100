
/**
 * 210. 课程表 II
 *
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 * 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 b
 * i 。
 * * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * 提示：
 * * 1 <= numCourses <= 2000
 * * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * * prerequisites[i].length == 2
 * * 0 <= ai, bi < numCourses
 * * ai != bi
 * * 所有[ai, bi] 互不相同
 *
 * 链接：https://leetcode.cn/problems/course-schedule-ii/
 */

import java.util.*;

public class T210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        ArrayList<Integer> result = new ArrayList<>();
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
        // 接下来就是验证是否能完成了 我们先查找入度为零的节点 也就是preLearn是空的。
        // 遍历所有的节点 将入度为零的节点 加入到队列queue
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i) || map.get(i).isEmpty()) {
                queue.add(i);
                result.add(i);
                visited[i] = true;
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
                        result.add(prerequisites[i][0]);
                        visited[prerequisites[i][0]] = true;
                    }
                }
            }
        }

        return result.size()==numCourses?result.stream()
                .mapToInt(Integer::intValue)
                .toArray():new int[]{};
    }
}
