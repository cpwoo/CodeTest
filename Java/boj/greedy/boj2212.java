package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj2212 {
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
        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        if(k >= n) {
            bw.write("0");
            return;
        }

        int[] d = new int[n-1];
        for(int i=0; i<n-1; i++) d[i] = arr[i+1]-arr[i];

        Arrays.sort(d);

        int ret = 0;
        for(int i=0; i<n-k; i++) ret += d[i];

        bw.write(ret+"");
    }

}
