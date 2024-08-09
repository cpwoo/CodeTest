package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj15678 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

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
        int d = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        long[] dp = new long[n];
        Deque<long[]> q = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            dp[i] = arr[i];
            
            while(!q.isEmpty() && q.peekFirst()[0] < i-d) q.pollFirst();

            if(!q.isEmpty()) dp[i] = Math.max(dp[i], q.peekFirst()[1]+arr[i]);

            while(!q.isEmpty() && q.peekLast()[1] < dp[i]) q.pollLast();

            q.add(new long[]{i, dp[i]});
        }

        long max = -987654321;
        for(int i=0; i<n; i++) max = Math.max(max, dp[i]);

        bw.write(max+"");
    }

}
