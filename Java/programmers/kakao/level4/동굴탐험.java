package CodeTest.Java.programmers.kakao.level4;

import java.util.*;

public class 동굴탐험 {
    private static List<List<Integer>> graph;
    private static int[] p_visited;
    private static int[] n_visited;
    private static boolean[] visited;

    public boolean solution(int n, int[][] path, int[][] order) {
        graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : path) {
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        p_visited = new int[n];
        
        for (int[] o : order) {
            p_visited[o[1]] = o[0];
        }

        n_visited = new int[n];
        visited = new boolean[n];

        dfs(0);

        int cnt = 0;
        for (int i=0; i<n; i++) {
            if (visited[i]) cnt++;
        }

        return cnt == n;
    }

    private static void dfs(int node) {
        Stack<Integer> stk = new Stack<>();
        stk.push(node);
        visited[node] = true;

        while (!stk.isEmpty()) {
            int cur = stk.pop();

            if (n_visited[cur] != 0) dfs(n_visited[cur]);
            
            if (!visited[p_visited[cur]]) {
                n_visited[p_visited[cur]] = cur;
                continue;
            }
            
            for (Integer nxt : graph.get(cur)) {    
                if (!visited[nxt]) {
                    stk.add(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }
}
