package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj13164 {
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
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] sub = new int[n-1];
        for(int i=0; i<n-1; i++) sub[i] = arr[i+1]-arr[i];

        Arrays.sort(sub);

        int sum = 0;
        for(int i=0; i<n-k; i++) sum += sub[i];
        
        bw.write(sum+"");
    }
}
