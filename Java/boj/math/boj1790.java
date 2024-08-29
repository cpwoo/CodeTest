package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1790 {
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
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long ans = 0, len = 1, cnt = 9;

        while(k > len*cnt) {
            k -= len*cnt;
            ans += cnt;
            len++;
            cnt *= 10;
        }

        ans = (ans+1)+((k-1)/len);

        char c = String.valueOf(ans).charAt((int)((k-1)%len));

        bw.write((ans > n) ? "-1" : c+"");
    }

}
