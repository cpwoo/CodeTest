package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj21757 {
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

        int[] sum = new int[n];
        sum[0] = arr[0];
        for(int i=1; i<n; i++) sum[i] = sum[i-1]+arr[i];

        long ret = 0;

        if(sum[n-1]%4 == 0) {
            int div = sum[n-1]/4;

            long[] cnt = new long[4];
            cnt[0] = 1;
            
            for(int i=0; i<n-1; i++) {
                if(sum[i] == div*3) cnt[3] += cnt[2];
                if(sum[i] == div*2) cnt[2] += cnt[1];
                if(sum[i] == div) cnt[1] += cnt[0];
            }
            
            ret = cnt[3];
        }

        bw.write(ret+"");
    }

}
