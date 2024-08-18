package CodeTest.Java.boj.topologicalSorting;

import java.io.*;
import java.util.*;

public class boj14567 {
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> arr[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) arr[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);

        for(int i=1; i<n+1; i++) {
            for(Integer b : arr[i]) {
                dp[b] = Math.max(dp[b], dp[i]+1);
            }
        }

        sb = new StringBuilder();
        for(int i=1; i<n+1; i++) sb.append(dp[i]).append(' ');

        bw.write(sb.toString());
    }

}
