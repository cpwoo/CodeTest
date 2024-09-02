package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj16927 {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] data = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) data[i][j] = Integer.parseInt(st.nextToken());
        }

        int sz = Math.min(N, M)/2;

        int[] turns = new int[sz];
        for(int k=0; k<sz; k++) turns[k] = 2*((N-2*k)+(M-2*k))-4;

        for(int k=0; k<sz; k++) {
            for(int r=0; r<R%turns[k]; r++) {
                int tmp = data[k][k];

                for(int i=1+k; i<M-k; i++) data[k][i-1] = data[k][i];

                for(int i=1+k; i<N-k; i++) data[i-1][M-1-k] = data[i][M-1-k];

                for(int i=1+k; i<M-k; i++) data[N-1-k][M-i] = data[N-1-k][M-1-i];

                for(int i=1+k; i<N-k; i++) data[N-i][k] = data[N-1-i][k];

                data[1+k][k] = tmp;
            }
        }

        sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(data[i][j]).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

}
