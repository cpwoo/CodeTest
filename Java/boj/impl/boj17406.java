package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj17406 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, m, k, A[][], rcs[][], ret;

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
        k = Integer.parseInt(st.nextToken());

        A = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        rcs = new int[k][3];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) rcs[i][j] = Integer.parseInt(st.nextToken());
        }

        ret = Integer.MAX_VALUE;

        dfs(new boolean[k], new int[k], 0);

        bw.write(ret+"");
    }

    private static void dfs(boolean[] visited, int[] output, int depth) {
        if(depth == k) {
            int[][] copyA = new int[n][m];
            for(int i=0; i<n; i++) for(int j=0; j<m; j++) copyA[i][j] = A[i][j];

            for(int i=0; i<k; i++) {
                int r = rcs[output[i]][0]-1, c = rcs[output[i]][1]-1, s = rcs[output[i]][2];

                for(int n=s; n>0; n--) {
                    int tmp = copyA[r-n][c+n];
                    
                    for(int col=c+n; col>c-n; col--) copyA[r-n][col] = copyA[r-n][col-1];

                    for(int row=r-n; row<r+n; row++) copyA[row][c-n] = copyA[row+1][c-n];

                    for(int col=c-n; col<c+n; col++) copyA[r+n][col] = copyA[r+n][col+1];

                    for(int row=r+n; row>r-n+1; row--) copyA[row][c+n] = copyA[row-1][c+n];

                    copyA[r-n+1][c+n] = tmp;
                }
            }

            for(int i=0; i<n; i++) {
                int sum = 0;
                for(int j=0; j<m; j++) {
                    sum += copyA[i][j];
                }
                ret = Math.min(ret, sum);
            }
            
            return;
        }

        for(int i=0; i<k; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                dfs(visited, output, depth+1);
                visited[i] = false;
            }
        }
    }

}
