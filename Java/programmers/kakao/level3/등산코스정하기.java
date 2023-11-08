package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

class Nxt {
    int node, cost;
    Nxt(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class 등산코스정하기 {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Arrays.sort(summits);

        Set<Integer> set = new HashSet<>();
        for (int summit : summits) set.add(summit);

        Map<Integer, List<Nxt>> graph = new HashMap<>();
        for (int i=0; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] path : paths) {
            int u = path[0], v = path[1], w = path[2];
            
            List<Nxt> uList = graph.get(u);
            uList.add(new Nxt(v, w));
            graph.put(u, uList);

            List<Nxt> vList = graph.get(v);
            vList.add(new Nxt(u, w));
            graph.put(v, vList);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });

        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        for (int gate : gates) {
            q.add(new int[]{0, gate});
            visited[gate] = 0;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_cost = cur[0], cur_node = cur[1];
            
            if (set.contains(cur_node)) continue;
            if (cur_cost > visited[cur_node]) continue;

            for (Nxt nxt : graph.get(cur_node)) {
                int nxt_node = nxt.node;
                int nxt_cost = nxt.cost;
                
                int cost = Math.max(cur_cost, nxt_cost);

                if (cost < visited[nxt_node]) {
                    visited[nxt_node] = cost;
                    q.add(new int[]{cost, nxt_node});
                }
            }
        }

        int[] answer = new int[]{0, Integer.MAX_VALUE};
        for (int summit : summits) {
            if (visited[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = visited[summit];
            }
        }

        return answer;
    }
}
