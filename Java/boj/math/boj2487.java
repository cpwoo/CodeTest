package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj2487 {
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

        boolean[] visited = new boolean[n+1];

        long ans = 1;
        for(int i=1; i<n+1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int j = arr[i];
                long k = 1;
                while(j != i) {
                    visited[j] = true;
                    j = arr[j];
                    k++;
                }
                ans = lcm(ans, k);
            }
        }

        bw.write(ans+"");
    }

    private static long lcm(long a, long b) {
        return a*b/gcd(a, b);
    }

    private static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}
