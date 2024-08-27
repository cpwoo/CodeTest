package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj28703 {
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
        
        int[] arr = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        for(int i=0; i<n; i++) {
            while(arr[i]*2 <= max) arr[i] *= 2;
        }

        Arrays.sort(arr);

        int ret = arr[n-1]-arr[0];
        for(int i=0; i<n-1; i++) {
            arr[i] *= 2;
            ret = Math.min(ret, arr[i]-arr[i+1]);
        }
        bw.write(ret+"");
    }
}
