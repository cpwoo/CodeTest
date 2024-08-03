package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1514 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static int N, dp[][][][][], fr[], to[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][10][10][10][2];
        for(int i=0; i<N+1; i++) for(int j=0; j<10; j++) for(int k=0; k<10; k++) for(int l=0; l<10; l++) {
            Arrays.fill(dp[i][j][k][l], -1);
        }
        
        fr = new int[N];
        String inp = br.readLine();
        for(int i=0; i<N; i++) fr[i] = inp.charAt(i)-'0';

        to = new int[N];
        inp = br.readLine();
        for(int i=0; i<N; i++) to[i] = inp.charAt(i)-'0';

        bw.write(Math.min(go(0, 0, 0, 0, 0), go(0, 0, 0, 0, 1))+"");
    }

    private static int go(int idx, int x, int y, int z, int flag) {
        if(idx == N) return 0;

        if(dp[idx][x][y][z][flag] != -1) return dp[idx][x][y][z][flag];

        dp[idx][x][y][z][flag] = 1000000000;

        if((fr[idx]+x+10)%10 == to[idx]) {
            dp[idx][x][y][z][flag] = Math.min(go(idx+1, y, z, 0, 0), go(idx+1, y, z, 0, 1));
        } else {
            int d = (flag != 0) ? 1 : -1;

            for(int k=1; k<4; k++) {
                int tx = (x+k*d+10)%10, ty = (y+k*d+10)%10, tz = (z+k*d+10)%10;

                dp[idx][x][y][z][flag] = Math.min(dp[idx][x][y][z][flag], 1+go(idx, tx, y, z, flag));
                dp[idx][x][y][z][flag] = Math.min(dp[idx][x][y][z][flag], 1+go(idx, tx, ty, z, flag));
                dp[idx][x][y][z][flag] = Math.min(dp[idx][x][y][z][flag], 1+go(idx, tx, ty, tz, flag));
            }
        }

        return dp[idx][x][y][z][flag];
    }

}

