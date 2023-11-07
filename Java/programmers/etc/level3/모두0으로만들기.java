package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 모두0으로만들기 {
    private static long answer = 0;
    private static long[] tot;
    private static List<List<Integer>> graph;
    private static int[] indegree;

    public long solution(int[] a, int[][] edges) {
        int n = a.length;

        tot = new long[n];
        for (int i=0; i<n; i++) {
            tot[i] = a[i];
            answer += a[i];
        }

        if (answer != 0) return -1;
        if (n == 2) return Math.abs(a[0]);
        
        graph = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        indegree = new int[n];
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<n; i++) {
            if (graph.get(i).size() == 1) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            answer += Math.abs(tot[cur]);
            indegree[cur]--;
            
            for (Integer nxt : graph.get(cur)) {
                if (indegree[nxt] == 0) continue;
                indegree[nxt]--;
                tot[nxt] += tot[cur];
                if (indegree[nxt] == 1) {
                    if(nxt == 0) continue;
                    q.add(nxt);
                }
            }
        }

        return answer;
    }
}
