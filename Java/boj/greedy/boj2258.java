package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj2258 {
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

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });

        long ans = Long.MAX_VALUE;
        long amount = 0, price = 0;
        boolean flag = false;

        for(int i=0; i<n; i++) {
            amount += arr[i][0];
            if(i-1 >= 0 && arr[i][1] == arr[i-1][1]) price += arr[i][1];
            else price = arr[i][1];

            if(amount >= m) {
                ans = Math.min(ans, price);
                flag = true;
            }
        }

        bw.write((flag) ? ans+"" : "-1");
    }

}
