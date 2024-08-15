package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj22862 {
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

        int[] s = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) s[i] = Integer.parseInt(st.nextToken());

        int end = 0, ret = 0, tmp = 0, cnt = 0;

        for(int start=0; start<n; start++) {
            while(cnt <= k && end < n) {
                if(s[end]%2 == 1) cnt++;
                else tmp++;
                end++;

                if(start == 0 && end == n) {
                    ret = tmp;
                    break;
                }
            }

            if(cnt == k+1) ret = Math.max(ret, tmp);

            if(s[start]%2 == 1) cnt--;
            else tmp--;
        }

        bw.write(ret+"");
    }

}
