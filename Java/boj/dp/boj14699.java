package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj14699 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static Set<Integer> graph[];
    private static int dp[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] height = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) height[i] = Integer.parseInt(st.nextToken());

        graph = new HashSet[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new HashSet<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(height[a] > height[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            graph[a].add(b);
        }

        dp = new int[n+1];

        for(int i=1; i<n+1; i++) cnt(i);

        sb = new StringBuilder();
        for(int i=1; i<n+1; i++) sb.append(dp[i]).append('\n');

        bw.write(sb.toString());
    }

    private static int cnt(int idx) {
        if(dp[idx] != 0) return dp[idx];

        dp[idx] = 1;

        for(Integer nxt : graph[idx]) dp[idx] = Math.max(dp[idx], cnt(nxt)+1);

        return dp[idx];
    }

}
