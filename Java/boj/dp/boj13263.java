package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj13263 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static Stack<long[]> k;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());

        int[] b = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) b[i] = Integer.parseInt(st.nextToken());

        long[] dp = new long[n];
        k = new Stack<>();
        k.add(new long[]{b[0], 0});
        
        for(int i=1; i<n; i++) {
            dp[i] = search(a[i]);
            add(new long[]{b[i], dp[i]});
        }

        bw.write(dp[n-1]+"");
    }

    private static long search(int p) {
        int left = 0, right = k.size()-1;

        while(left < right) {
            int mid = (left+right)/2;
            if(gradient(k.get(mid), k.get(mid+1)) <= p) {
                left = mid+1;
            }
            else right = mid;
        }

        return k.get(left)[0]*p + k.get(left)[1];
    }

    private static void add(long[] p) {
        while(k.size() > 1 && gradient(k.get(k.size()-2), k.get(k.size()-1)) > gradient(k.get(k.size()-1), p)) {
            k.pop();
        }
        k.add(p);
    }

    private static long gradient(long[] a, long[] b) {
        return (a[1]-b[1])/(b[0]-a[0]);
    }

}
