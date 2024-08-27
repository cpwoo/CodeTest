package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj20207 {
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
        int[] ans = new int[367];

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for(int i=s; i<e+1; i++) ans[i]++;
        }

        int ret = 0;
        int cnt = 0, max = 0;

        for(int i=1; i<367; i++) {
            if(ans[i] != 0) {
                cnt++;
                max = Math.max(max, ans[i]);
            }
            else {
                ret += cnt*max;
                cnt = max = 0;
            }
        }

        bw.write(ret+"");
    }
}
