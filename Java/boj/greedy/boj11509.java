package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj11509 {
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
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] res = new int[1000001];

        for(int a : arr) {
            if(res[a] > 0) res[a]--;
            res[a-1]++;
        }

        int sum = 0;
        for(int i=0; i<1000001; i++) sum += res[i];

        bw.write(sum+"");
    }
}
