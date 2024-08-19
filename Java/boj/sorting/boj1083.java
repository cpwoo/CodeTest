package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj1083 {
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
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(br.readLine());
        for(int i=0; i<n-1; i++) {
            if(s == 0) break;
            int mx = arr[i], idx = i;
            for(int j=i+1; j<Math.min(n, i+1+s); j++) {
                if(mx < arr[j]) {
                    mx = arr[j]; idx = j;
                }
            }
            s -= idx-i;
            for(int j=idx; j>i; j--) {
                arr[j] = arr[j-1];
            }
            arr[i] = mx;
        }

        sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(arr[i]).append(' ');

        bw.write(sb.toString());
    }

}
