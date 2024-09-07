package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj21278 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int INF = 1_000_000_000;

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
        int M = Integer.parseInt(st.nextToken());

        int[][] cost = new int[N][N];
        for(int i=0; i<N; i++) {
            Arrays.fill(cost[i], INF);
            cost[i][i] = 0;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a--; b--;
            cost[a][b] = 1;
            cost[b][a] = 1;
        }

        for(int k=0; k<N; k++) for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
        }

        int max = INF;
        int[] ans = new int[3];
        for(int i=0; i<N-1; i++) for(int j=1; j<N; j++) {
            int tot = 0;
            for(int k=0; k<N; k++) tot += Math.min(cost[k][i], cost[k][j]);
            if(max > tot*2) {
                max = 2*tot;
                ans[0] = i+1; ans[1] = j+1; ans[2] = tot*2;
            }
        }

        bw.write(ans[0]+" "+ans[1]+" "+ans[2]+"");
    }

}
