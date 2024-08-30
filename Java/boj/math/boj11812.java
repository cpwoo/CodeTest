package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj11812 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();

        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            if(k == 1) sb.append(Math.abs(x-y));
            else {
                int cnt = 0;
                while(x != y) {
                    while(x > y) {
                        cnt++;
                        x = (x+k-2)/k;
                    }
                    while(y > x) {
                        cnt++;
                        y = (y+k-2)/k;
                    }
                }
                sb.append(cnt);
            }

            sb.append('\n');
        }

        bw.write(sb.toString());
    }

}
