package CodeTest.Java.programmers.kakao.level4;

import java.util.*;

public class 매출하락최소화 {
    private static Map<Integer, List<Integer>> graph;
    private static int[][] cost;

    public int solution(int[] sales, int[][] links) {
        int n = sales.length;

        graph = new HashMap<>();
        for (int i=0; i<n; i++) graph.put(i, new ArrayList<>());

        for (int[] link : links) {
            List<Integer> u = graph.get(link[0]-1);
            u.add(link[1]-1);
            graph.put(link[0]-1, u);
        }

        cost = new int[n][2];

        dfs(sales, 0);

        return Math.min(cost[0][0], cost[0][1]);
    }

    private static void dfs(int[] sales, int cur) {
        cost[cur][0] = 0;
        cost[cur][1] = sales[cur];

        if (graph.get(cur).isEmpty()) return;

        int extra = Integer.MAX_VALUE;

        for (Integer nxt : graph.get(cur)) {
            dfs(sales, nxt);

            if (cost[nxt][0] < cost[nxt][1]) {
                cost[cur][0] += cost[nxt][0];
                cost[cur][1] += cost[nxt][0];
                extra = Math.min(extra, cost[nxt][1]-cost[nxt][0]);
            } else {
                cost[cur][0] += cost[nxt][1];
                cost[cur][1] += cost[nxt][1];
                extra = 0;
            }
        }

        cost[cur][0] += extra;
    }
}
