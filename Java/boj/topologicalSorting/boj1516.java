package CodeTest.Java.boj.topologicalSorting;

import java.io.*;
import java.util.*;

public class boj1516 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[] indegree = new int[n+1];
        int[] times = new int[n+1];
        int[] dp = new int[n+1];

        List<Integer> graph[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int j = Integer.parseInt(st.nextToken());
                if(j == -1) break;
                graph[j].add(i);
                indegree[i]++;
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=1; i<n+1; i++) if(indegree[i] == 0) {
            q.add(i); dp[i] = times[i];
        }

        while(!q.isEmpty()) {
            int now = q.pollFirst();
            for(Integer nxt : graph[now]) {
                indegree[nxt]--;
                dp[nxt] = Math.max(dp[nxt], dp[now]+times[nxt]);
                if(indegree[nxt] == 0) q.add(nxt);
            }
        }

        sb = new StringBuilder();

        for(int i=0; i<n+1; i++) if(dp[i] != 0) sb.append(dp[i]).append('\n');

        bw.write(sb.toString());
    }

}
