package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.util.*;

public class boj1648 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, m, dp[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[14*14][1<<14];

        for(int i=0; i<14*14; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(fill(0,0)+"");
    }

    private static int fill(int num, int status) {
        if(num == n*m && status == 0) return 1;

        if(num >= n*m) return 0;

        if(dp[num][status] != -1) return dp[num][status];

        dp[num][status] = 0;

        if((status&1) != 0) {
            dp[num][status] = fill(num+1, status>>1);
        } else {
            dp[num][status] = fill(num+1, (status>>1)|(1<<(m-1)));
            if(num%m != m-1 && (status&2) == 0) {
                dp[num][status] += fill(num+2, status>>2);
            }
        }

        dp[num][status] %= 9901;
        
        return dp[num][status];
    }

}
