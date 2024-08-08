package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj14863 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, K, dp[][], arr[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N][K+1];
        for(int i=0; i<N; i++) Arrays.fill(dp[i], -1);

        arr = new int[N][4];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(dfs(0, K)+"");
    }

    private static int dfs(int idx, int tot) {
        if(tot < 0) return -987654321;

        if(idx == N) return 0;

        if(dp[idx][tot] != -1) return dp[idx][tot];

        int a = arr[idx][0], b = arr[idx][1], c = arr[idx][2], d = arr[idx][3];

        return dp[idx][tot] = Math.max(dfs(idx+1, tot-a)+b, dfs(idx+1, tot-c)+d);
    }

}
