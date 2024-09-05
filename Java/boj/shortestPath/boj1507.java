package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1507 {
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

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] edge = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(edge[i], 1);

        int ret = 0;

        for(int k=0; k<n; k++) for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(i == j || j == k || k == i) continue;

            if(matrix[i][j] == matrix[i][k]+matrix[k][j]) edge[i][j] = 0;

            else if(matrix[i][j] > matrix[i][k]+matrix[k][j]) ret = -1;
        }

        if(ret != -1) {
            for(int i=0; i<n; i++) for(int j=i; j<n; j++) {
                if(edge[i][j] != 0) ret += matrix[i][j];
            }
        }

        bw.write(ret+"");
    }

}
