package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj1407 {
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
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        bw.write(calc(b)-calc(a-1)+"");
    }

    private static long calc(long x) {
        long ret = x, mul = 2;

        while(mul <= x) {
            ret += (x/mul)*(mul/2);
            mul <<= 1;
        }

        return ret;
    }

}
