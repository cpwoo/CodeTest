package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj2213 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int n, w[], dp[][];
    private static List<Integer> s[], num[][];
    private static boolean v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        w = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) w[i] = Integer.parseInt(st.nextToken());

        s = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) s[i] = new ArrayList<>();

        dp = new int[n+1][2];
        v = new boolean[n+1];
        
        num = new ArrayList[n+1][2];
        for(int i=0; i<n+1; i++) for(int j=0; j<2; j++) num[i][j] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            s[a].add(b); s[b].add(a);
        }

        dfs(1);

        sb = new StringBuilder();

        if(dp[1][0] >= dp[1][1]) {
            sb.append(dp[1][0]).append('\n');
            Collections.sort(num[1][0]);
            for(Integer i : num[1][0]) sb.append(i).append(' ');
        }
        else {
            sb.append(dp[1][1]).append('\n');
            Collections.sort(num[1][1]);
            for(Integer i : num[1][1]) sb.append(i).append(' ');
        }

        bw.write(sb.toString());
    }

    private static void dfs(int start) {
        v[start] = true;
        dp[start][0] = w[start];
        num[start][0].add(start);

        for(Integer i : s[start]) {
            if(!v[i]) {
                dfs(i);
                dp[start][0] += dp[i][1];
                for(Integer j : num[i][1]) {
                    num[start][0].add(j);
                }

                if(dp[i][0] <= dp[i][1]) {
                    dp[start][1] += dp[i][1];
                    for(Integer k : num[i][1]) {
                        num[start][1].add(k);
                    }
                }
                else {
                    dp[start][1] += dp[i][0];
                    for(Integer k : num[i][0]) {
                        num[start][1].add(k);
                    }
                }
            }
        }
    }

}
