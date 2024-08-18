package CodeTest.Java.boj.topologicalSorting;

import java.io.*;
import java.util.*;

public class boj9470 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> graph[] = new ArrayList[m+1];
        for(int i=0; i<m+1; i++) graph[i] = new ArrayList<>();

        int[] degree = new int[m+1];
        int[][] cnt = new int[m+1][2];
        int[] dp = new int[m+1];

        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            degree[b]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=1; i<m+1; i++) if(degree[i] == 0) {
            q.add(i); cnt[i][0] = cnt[i][1] = 1;
        }

        while(!q.isEmpty()) {
            int cur = q.pollFirst();

            dp[cur] = (cnt[cur][1] >= 2) ? cnt[cur][0]+1 : cnt[cur][0];

            for(Integer nxt : graph[cur]) {
                degree[nxt]--;

                if(cnt[nxt][0] == dp[cur]) cnt[nxt][1]++;
                else if(cnt[nxt][0] < dp[cur]) {
                    cnt[nxt][0] = dp[cur]; cnt[nxt][1] = 1;
                }

                if(degree[nxt] == 0) q.add(nxt);
            }
        }

        sb.append(k).append(' ').append(dp[m]).append('\n');
    }

}
