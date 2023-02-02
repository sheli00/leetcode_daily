import java.util.*;

public class problem1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //next[0][0] = [1, 2]代表节点0到节点1和节点2存在红边
        List<Integer>[][] next = new List[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                //每个节点的红蓝边next各初始化为数组
                next[i][j] = new ArrayList<>();
            }
        }
        for (int[] edge : redEdges) {
            next[0][edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            next[1][edge[0]].add(edge[1]);
        }
        //最终边的两种颜色最短路径长度
        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            //初始化为最大值
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        dist[0][0] = 0;
        dist[1][0] = 0;
        queue.offer(new int[] {0, 0});
        queue.offer(new int[] {1, 0});
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int t = data[0], x = data[1];
            for (int y : next[1 - t][x]) {
                //当前节点异色的下一个节点
                if (dist[1 - t][y] != Integer.MAX_VALUE) {
                    continue;
                }
                dist[1 - t][y] = dist[t][x] + 1;
                //将下一个节点加进队列
                queue.offer(new int[] {1 - t, y});
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(dist[0][i], dist[1][i]);
            ans[i] = ans[i] == Integer.MAX_VALUE ? -1 : ans[i];
        }
        return ans;
    }
}
