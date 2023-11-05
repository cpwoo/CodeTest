package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        visited[1] = true;
        int answer = 0, maxDepth = 0;

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int cur = info[0], depth = info[1];
            if (maxDepth == depth) answer++;
            else if (maxDepth < depth) {
                maxDepth = depth;
                answer = 1;
            }
            for (Integer nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(new int[]{nxt, depth+1});
                }
            }
        }

        return answer;
    }
}
