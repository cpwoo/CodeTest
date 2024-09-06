package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj14938 {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] item = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) item[i] = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            a--; b--;
            arr[a][b] = Math.min(arr[a][b], c);
            arr[b][a] = Math.min(arr[b][a], c);
        }

        for(int k=0; k<n; k++) for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            int tmp = 0;
            for(int j=0; j<n; j++) {
                if(arr[i][j] <= m) tmp += item[j];
            }
            max = Math.max(max, tmp);
        }

        bw.write(max+"");
    }

}
