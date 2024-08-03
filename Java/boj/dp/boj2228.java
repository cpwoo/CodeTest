package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2228 {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] include = new int[n+1][m+1];
        int[][] notInclude = new int[n+1][m+1];
        for(int i=0; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                include[i][j] = -100000000;
                notInclude[i][j] = -100000000;
            }
        }

        for(int i=1; i<n+1; i++) {
            int x = Integer.parseInt(br.readLine());
            for(int j=1; j<Math.min(m,(i+1)/2)+1; j++) {
                notInclude[i][j] = Math.max(include[i-1][j], notInclude[i-1][j]);
                include[i][j] = Math.max(include[i-1][j], notInclude[i-1][j-1])+x;
            }
        }

        bw.write(Math.max(include[n][m], notInclude[n][m])+"");
    }

}
