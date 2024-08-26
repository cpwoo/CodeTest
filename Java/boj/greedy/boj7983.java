package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj7983 {
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
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });

        int end = arr[0][1]-arr[0][0];

        for(int i=1; i<n; i++) {
            end = (end > arr[i][1]) ? arr[i][1]-arr[i][0] : end-arr[i][0];
        }

        bw.write(end+"");
    }
}
