package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj2533 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Integer> graph[];
    private static int dp[][];
    private static boolean v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        dp = new int[n+1][2];

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b); graph[b].add(a);
        }

        v = new boolean[n+1];

        dfs(1);
        bw.write(Math.min(dp[1][0], dp[1][1])+"");
    }

    private static void dfs(int start) {
        v[start] = true;
        if(graph[start].isEmpty()) {
            dp[start][1] = 1;
            dp[start][0] = 0;
        }
        else {
            for(Integer i : graph[start]) {
                if(!v[i]) {
                    dfs(i);
                    dp[start][1] += Math.min(dp[i][0], dp[i][1]);
                    dp[start][0] += dp[i][1];
                }
            }
            dp[start][1]++;
        }
    }

}
