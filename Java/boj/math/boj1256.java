package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

// String 의 repeat 메소드는 Java 11부터 추가되므로 Java 11로 제출

public class boj1256 {
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
        long K = Long.parseLong(st.nextToken());

        long[][] arr = new long[N+1][M+1];
        for(int i=0; i<N+1; i++) Arrays.fill(arr[i], 1);

        for(int i=1; i<N+1; i++) for(int j=1; j<M+1; j++) {
            arr[i][j] = arr[i-1][j]+arr[i][j-1];
            if(arr[i][j] > 1000000000) arr[i][j] = 1000000001; // overflow 방지
        }

        if(arr[N][M] < K) {
            bw.write("-1");
            return;
        }

        sb = new StringBuilder();
        while(N > 0 && M > 0) {
            long flag = arr[N-1][M];
            if(K <= flag) {
                sb.append("a");
                N--;
            }
            else {
                sb.append("z");
                M--;
                K -= flag;
            }
        }

        while(N-- > 0) sb.append("a");
        while(M-- > 0) sb.append("z");

        bw.write(sb.toString());
    }

}
