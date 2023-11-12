package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class GPS {
    private static Map<Integer, List<Integer>> graph;

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        graph = new HashMap<>();
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edge_list) {
            List<Integer> u = graph.get(edge[0]);
            u.add(edge[1]);
            graph.put(edge[0], u);

            List<Integer> v = graph.get(edge[1]);
            v.add(edge[0]);
            graph.put(edge[1], v);
        }

        int[][] dp = new int[k][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, k+1);
        }
        dp[0][gps_log[0]] = 0;

        for (int i=1; i<k; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                for (Integer nxt : graph.get(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][nxt]);
                }
                dp[i][j] += (gps_log[i] == j) ? 0 : 1;
            }
        }

        return (dp[k-1][gps_log[k-1]] > k) ? -1 : dp[k-1][gps_log[k-1]];
    }
}
