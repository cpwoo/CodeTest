package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj12851 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int max = 100001;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[max];
        Arrays.fill(dp, -1);
        dp[N] = 0;

        Deque<Integer> q = new ArrayDeque<>();
        q.add(N);

        int cnt = 0;
        while(!q.isEmpty()) {
            int x = q.poll();
            if(x == K) cnt++;

            for(int nx : new int[]{x-1, x+1, 2*x}) {
                if(0 <= nx && nx < max && (dp[nx] == -1 || dp[nx] >= dp[x]+1)) {
                    dp[nx] = dp[x]+1;
                    q.add(nx);
                }
            }
        }

        bw.write(dp[K]+"\n"+cnt+"");
    }
}
