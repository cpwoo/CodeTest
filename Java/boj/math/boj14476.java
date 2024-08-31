package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj14476 {
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

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] lg = new int[n+2];
        int[] rg = new int[n+2];

        lg[1] = arr[1]; rg[n] = arr[n];

        for(int i=2; i<n+1; i++) lg[i] = gcd(lg[i-1], arr[i]);

        for(int i=n-1; i>0; i--) rg[i] = gcd(rg[i+1], arr[i]);

        int[] ans = new int[2];
        for(int i=1; i<n+1; i++) {
            int g = gcd(lg[i-1], rg[i+1]);
            if(arr[i]%g != 0 && ans[0] < g) {
                ans[0] = g;
                ans[1] = arr[i];
            }
        }

        bw.write((ans[0] == 0 && ans[1] == 0) ? "-1" : ans[0]+" "+ans[1]+"");
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}
