package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2159 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dy = {1,-1,0,0,0};
    private static final int[] dx = {0,0,1,-1,0};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] cakes = new int[n+1][2];
        for(int i=0; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cakes[i][0] = a; cakes[i][1] = b;
        }

        long[][] distance = new long[n+1][5];
        for(int i=0; i<n+1; i++) {
            Arrays.fill(distance[i], 200000000000L);
        }

        for(int k=0; k<4; k++) distance[0][k] = 1;
        distance[0][4] = 0;

        for(int i=1; i<n+1; i++) {
            for(int k=0; k<5; k++) {
                int y = cakes[i][0]+dy[k], x = cakes[i][1]+dx[k];
                for(int j=0; j<5; j++) {
                    int ey = cakes[i-1][0]+dy[j], ex = cakes[i-1][1]+dx[j];
                    distance[i][k] = Math.min(distance[i][k], Math.abs(ey-y)+Math.abs(ex-x)+distance[i-1][j]);
                }
            }
        }

        long ret = 200000000000L;
        for(int i=0; i<5; i++) ret = Math.min(ret, distance[n][i]);

        bw.write(ret+"");
    }

}
