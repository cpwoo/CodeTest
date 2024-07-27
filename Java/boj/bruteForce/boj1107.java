package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj1107 {
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
        int target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        if(n != 0) {
            st = new StringTokenizer(br.readLine());
        }
        for(int i=0; i<n; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }

        int cnt = Math.abs(100-target);

        for(int nums=0; nums<1000001; nums++) {
            String st = String.valueOf(nums);
            int L = st.length();

            for(int i=0; i<L; i++) {
                if(broken[st.charAt(i)-'0']) break;
                else if(i == L-1) {
                    cnt = Math.min(cnt, Math.abs(nums-target)+L);
                }
            }
        }

        bw.write(cnt+"");
    }

}
