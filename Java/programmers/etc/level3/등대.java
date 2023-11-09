package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 등대 {
    private static List<Set<Integer>> arr;
    private static int[] visited;

    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        arr = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            arr.add(new HashSet<>());
        }

        for (int[] node : lighthouse) {
            arr.get(node[0]-1).add(node[1]-1);
            arr.get(node[1]-1).add(node[0]-1);
        }

        visited = new int[n];
        
        dfs(0);
        
        for (int v : visited) {
            if (v == 2) answer++;
        }

        return answer;
    }

    private static void dfs(int cur) {
        visited[cur] = 1;
        Set<Integer> set = arr.get(cur);
        for (int nxt : set) {
            if (visited[nxt] == 0) {
                dfs(nxt);
                if (visited[nxt] == 1) {
                    visited[nxt] = 2;
                }
            }
        }
    }
}
