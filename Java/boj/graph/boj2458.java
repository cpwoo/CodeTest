package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2458 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

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

        int[][] arr = new int[N][N];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[v-1][e-1] = 1;
        }

        for(int k=0; k<N; k++) for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
        }

        int ret = 0;
        for(int i=0; i<N; i++) {
            int chk = 0;
            for(int j=0; j<N; j++) chk += arr[i][j]+arr[j][i];
            if(chk == N-1) ret++;
        }

        bw.write(ret+"");
    }

}
