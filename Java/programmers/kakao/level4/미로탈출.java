package CodeTest.Java.programmers.kakao.level4;

import java.util.*;

public class 미로탈출 {
    private static final int MAX_N = 1001;
    private static int[][] graph = new int[MAX_N][MAX_N];
    private static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                graph[i][j] = (i==j) ? 0 : INF;
            }
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph[u][v] = Math.min(graph[u][v], w);
        }

        return dijkstra(n, start, end, traps);
    }

    private static int dijkstra(int n, int src, int dst, int[] traps) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
        pq.add(new int[]{0, src, 0});

        boolean[][] visited = new boolean[MAX_N][1<<10];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int w = cur[0], u = cur[1], state = cur[2];

            if (u == dst) return w;
            if (visited[u][state]) continue;
            visited[u][state] = true;

            boolean curTrapped = false;
            Map<Integer, Boolean> trapped = new HashMap<>();
            for (int i=0; i<traps.length; i++) {
                int bit = 1<<i;
                if ((state&bit) != 0) {
                    if (traps[i] == u) {
                        state &= ~bit;
                    } else {
                        trapped.put(traps[i], true);
                    }
                } else {
                    if (traps[i] == u) {
                        state |= bit;
                        trapped.put(traps[i], true);
                        curTrapped = true;
                    }
                }
            }

            for (int v=1; v<=n; v++) {
                if (v == u) continue;
                boolean nxtTrapped = trapped.containsKey(v);
                if (curTrapped == nxtTrapped) {
                    if (graph[u][v] != INF) pq.add(new int[]{w+graph[u][v], v, state});
                } else {
                    if (graph[v][u] != INF) pq.add(new int[]{w+graph[v][u], v, state});
                }
            }
        }

        return INF;
    }
}
