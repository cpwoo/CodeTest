package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.util.*;

public class boj1102 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, p, graph[][], dp[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[1<<n];
        Arrays.fill(dp, -1);

        String s = br.readLine();
        p = Integer.parseInt(br.readLine());

        int now = 0, time = 0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == 'Y') {
                time++;
                now |= (1<<i);
            }
        }

        int ret = gen(now, time);
        if(ret >= 1000000) ret = -1;

        bw.write(ret+"");
    }

    private static int gen(int now, int time) {
        if(time >= p) return 0;
        if(dp[now] != -1) return dp[now];
        
        int r = 1000000;
        for(int i=0; i<n; i++) {
            if((now&(1<<i)) != 0) {
                for(int j=0; j<n; j++) {
                    if((now&(1<<j)) == 0) {
                        r = Math.min(r, gen(now|(1<<j), time+1)+graph[i][j]);
                    }
                }
            }
        }

        return dp[now] = r;
    }

}
