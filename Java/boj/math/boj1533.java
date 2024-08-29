package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1533 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int mod = 1000003;
    private static int n;

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
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        s--; e--;

        long[][] matrix = new long[5*n+1][5*n+1];

        for(int i=0; i<n; i++) {
            char[] inp = br.readLine().toCharArray();
            for(int j=0; j<n; j++) {
                int cur = inp[j]-'0';
                if(cur > 0) matrix[5*i+cur-1][5*j] = 1;
            }
            for(int j=0; j<4; j++) {
                matrix[5*i+j][5*i+j+1] = 1;
            }
        }

        long[][] ans = new long[5*n+1][5*n+1];
        for(int i=0; i<5*n+1; i++) for(int j=0; j<5*n+1; j++) {
            ans[i][j] = matrix[i][j];
        }

        t--;

        while(t > 0) {
            if(t%2 == 1) ans = mul(ans, matrix);

            matrix = mul(matrix, matrix);
            t /= 2;
        }

        bw.write(ans[s*5][e*5]+"");
    }

    private static long[][] mul(long[][] a, long[][] b) {
        long[][] ret = new long[5*n+1][5*n+1];
        
        for(int i=0; i<5*n+1; i++) for(int j=0; j<5*n+1; j++) for(int k=0; k<5*n+1; k++) {
            ret[i][j] = (ret[i][j]+a[i][k]*b[k][j])%mod;
        }

        return ret;
    }

}
