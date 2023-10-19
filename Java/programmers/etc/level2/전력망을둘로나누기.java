package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        for (int[] wire : wires) {
            boolean[] visited = new boolean[n+1];
            visited[wire[1]] = true;
            int res = bfs(wire[0], visited, graph);
            answer = Math.min(answer, Math.abs(res-(n-res)));
        }

        return answer;
    }

    private int bfs(int node, boolean[] visited, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        int res = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    res++;
                    q.add(nxt);
                }
            }
        }

        return res;
    }
}
