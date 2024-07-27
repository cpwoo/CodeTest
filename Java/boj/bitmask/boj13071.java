package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.util.*;

public class boj13071 {
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
        int[] bit = new int[1048576];

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int m = Integer.parseInt(st.nextToken());
            int idx = m/32;
            int sft = (1<<(m%32));

            if((bit[idx]&sft) == 0) {
                bw.write(m+" ");
                bit[idx] |= sft;
            }
        }
    }

}
