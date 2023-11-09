package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        
        q.add(destination);
        visited[destination] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer nxt : graph.get(cur)) {
                if (visited[nxt] == -1) {
                    visited[nxt] = visited[cur]+1;
                    q.add(nxt);
                }
            }
        }

        int idx = 0;
        for (int source : sources) {
            answer[idx++] = visited[source];
        }

        return answer;
    }
}
