package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj1949 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Integer> graph[];
    private static boolean v[];
    private static int dp[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) score[i] = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        v = new boolean[n+1];
        dp = new int[n+1][2];
        for(int i=0; i<n+1; i++) dp[i][1] = score[i];

        dfs(1);

        bw.write(Math.max(dp[1][0], dp[1][1])+"");
    }

    private static void dfs(int cur) {
        v[cur] = true;
        for(Integer nxt : graph[cur]) {
            if(!v[nxt]) {
                dfs(nxt);
                dp[cur][0] += Math.max(dp[nxt][0], dp[nxt][1]);
                dp[cur][1] += dp[nxt][0];
            }
        }
    }

}
