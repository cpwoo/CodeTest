package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj25306 {
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

        bw.write((f(a-1)^f(b))+"");
    }

    private static long f(long n) {
        long x = n%4;
        if(x == 0) return n;
        else if(x == 1) return 1;
        else if(x == 2) return n+1;
        else return 0;
    }

}
