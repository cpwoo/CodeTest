package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj3955 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int max = 1_000_000_000;

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
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] ret = extendedGCD(c, k);
        int x0 = ret[0], x1 = ret[1], y1 = ret[3];

        if(c == 1) {
            bw.write((k >= max) ? "IMPOSSIBLE\n" : k+1+"\n");
        }
        else if(x1 != -k && y1 != -c) bw.write("IMPOSSIBLE\n");
        else {
            int ans = (x0 > 0) ? x0 : x0+x1;
            bw.write((ans > max) ? "IMPOSSIBLE\n" : ans+"\n");
        }
    }

    private static int[] extendedGCD(int a, int b) {
        int x0 = 1, x1 = 0, y0 = 0, y1 = 1;
        
        while(b != 0) {
            int n = a/b;
            int tmp = a%b;
            a = b;
            b = tmp;

            int tmpX = x0-n*x1;
            x0 = x1;
            x1 = tmpX;

            int tmpY = y0-n*y1;
            y0 = y1;
            y1 = tmpY;
        }

        return new int[]{x0, x1, y0, y1};
    }

}
