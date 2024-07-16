package CodeTest.Java.boj.prefixSum;

import java.io.*;
import java.util.*;

public class boj21758 {
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
        int ans = 0;
        
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 누적 합
        int[] s = new int[n];
        s[0] = a[0];
        for(int i=1; i<n; i++) {
            s[i] = s[i-1]+a[i];
        }

        // 꿀통이 왼쪽 끝 -> 오른쪽 끝 -> 가운데
        for(int i=1; i<n-1; i++) {
            ans = Math.max(ans, s[n-2]+s[i-1]-a[i]);
            ans = Math.max(ans, s[n-1]-a[0]+s[n-1]-s[i]-a[i]);
            ans = Math.max(ans, s[n-2]-a[0]+a[i]);
        }

        bw.write(ans+"");
    }

}
