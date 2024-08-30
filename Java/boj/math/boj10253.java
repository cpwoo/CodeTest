package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj10253 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while(a != 1) {
            int c = b/a+1;
            a = a*c-b;
            b = b*c;
            int G = gcd(a, b);
            a = a/G; b = b/G;
        }
        
        sb.append(b).append('\n');
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}
