package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj1451 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, m, table[][];
    
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

        table = new int[n][m];
        for(int i=0; i<n; i++) {
            String inp = br.readLine();
            for(int j=0; j<m; j++) {
                table[i][j] = inp.charAt(j)-'0';
            }
        }

        long ans = 0;

        long s1, s2, s3;
        for(int i=1; i<m-1; i++) {
            for(int j=i+1; j<m; j++) {
                s1 = sum(0, n, 0, i);
                s2 = sum(0, n, i, j);
                s3 = sum(0, n, j, m);
                ans = Math.max(ans, s1*s2*s3);
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                s1 = sum(0, j, 0, i);
                s2 = sum(0, j, i, m);
                s3 = sum(j, n, 0, m);
                ans = Math.max(ans, s1*s2*s3);
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                s1 = sum(0, i, 0, m);
                s2 = sum(i, n, 0, j);
                s3 = sum(i, n, j, m);
                ans = Math.max(ans, s1*s2*s3);
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                s1 = sum(0, i, 0, j);
                s2 = sum(i, n, 0, j);
                s3 = sum(0, n, j, m);
                ans = Math.max(ans, s1*s2*s3);
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                s1 = sum(0, i, j, m);
                s2 = sum(i, n, j, m);
                s3 = sum(0, n, 0, j);
                ans = Math.max(ans, s1*s2*s3);
            }
        }

        for(int i=1; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                s1 = sum(0, i, 0, m);
                s2 = sum(i, j, 0, m);
                s3 = sum(j, n, 0, m);
                ans = Math.max(ans, s1*s2*s3);
            }
        }

        bw.write(ans+"");
    }

    private static long sum(int p, int q, int r, int s) {
        long tmp = 0;

        for(int i=p; i<q; i++) {
            for(int j=r; j<s; j++) {
                tmp += table[i][j];
            }
        }

        return tmp;
    }

}
