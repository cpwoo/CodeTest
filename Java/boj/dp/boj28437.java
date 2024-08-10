package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj28437 {
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
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        int Q = Integer.parseInt(br.readLine());

        int[] L = new int[Q];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++) L[i] = Integer.parseInt(st.nextToken());

        long[] dp = new long[100001];
        for(int a: A) dp[a]++;

        for(int j=1; j<100001; j++) {
            for(int i=2*j; i<100001; i+=j) {
                dp[i] += dp[j];
            }
        }

        sb = new StringBuilder();
        for(Integer i : L) sb.append(dp[i]).append(' ');
        
        bw.write(sb.toString());
    }

}
