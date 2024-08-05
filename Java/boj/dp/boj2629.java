package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2629 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int n, weight[], m, marble[];
    private static boolean dp[][];
    private static Set<Integer> possible;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) weight[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        marble = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) marble[i] = Integer.parseInt(st.nextToken());

        dp = new boolean[n+1][15001];

        possible = new HashSet<>();

        scale(0, 0, 0);

        sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            sb.append((possible.contains(marble[i])) ? 'Y' : 'N').append(' ');
        }

        bw.write(sb.toString());
    }

    private static void scale(int depth, int left, int right) {
        int diff = Math.abs(left-right);

        if(!possible.contains(diff)) possible.add(diff);

        if(depth == n) return;

        if(!dp[depth][diff]) {
            scale(depth+1, left+weight[depth], right);
            scale(depth+1, left, right+weight[depth]);
            scale(depth+1, left, right);

            dp[depth][diff] = true;
        }
    }

}
