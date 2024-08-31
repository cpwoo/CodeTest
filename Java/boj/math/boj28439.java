package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj28439 {
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

        int[][] A = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i=0; i<N; i++) cnt.put(A[0][0]-A[i][0], cnt.getOrDefault(A[0][0]-A[i][0], 0)+1);
        for(int i=0; i<M; i++) cnt.put(A[0][i], cnt.getOrDefault(A[0][i], 0)+1);

        int mxv = 0, mxc = 0;
        for(Integer v : cnt.keySet()) {
            if(mxc < cnt.get(v)) {
                mxv = v; mxc = cnt.get(v);
            }
        }

        int[] R = new int[N];
        for(int i=0; i<N; i++) R[i] = mxv+A[i][0]-A[0][0];

        int[] C = new int[M];
        for(int i=0; i<M; i++) C[i] = A[0][i]-mxv;

        for(int i=0; i<N; i++) for(int j=0; j<M; j++) {
            if(R[i]+C[j] != A[i][j]) {
                bw.write("-1");
                return;
            }
        }

        sb = new StringBuilder();

        sb.append(N+M-mxc).append('\n');
        for(int i=0; i<N; i++) {
            if(R[i] != 0) sb.append(String.format("%d %d %d\n", 1, i+1, R[i]));
        }

        for(int i=0; i<M; i++) {
            if(C[i] != 0) sb.append(String.format("%d %d %d\n", 2, i+1, C[i]));
        }

        bw.write(sb.toString());
    }

}
