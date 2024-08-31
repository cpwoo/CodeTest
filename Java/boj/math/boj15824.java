package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj15824 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int mod = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        long answer = 0;
        for(int i=0; i<n; i++) {
            answer = (answer+arr[i]*(pow(2, i)-pow(2, n-i-1)))%mod;
        }

        bw.write(answer+"");
    }

    private static long pow(int a, int b) {
        if(b == 0) return 1;

        if(b == 1) return a;

        long half = pow(a, b/2);

        return (b%2 == 0) ? (half*half)%mod : (half*half*a)%mod;
    }

}
