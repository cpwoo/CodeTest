package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1011 {
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
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int d = y-x, sqrt = (int) Math.sqrt(d);

        if(sqrt == Math.sqrt(d)) sb.append(2*sqrt-1).append('\n');
        else if(d <= sqrt*sqrt+sqrt) sb.append(2*sqrt).append('\n');
        else sb.append(2*sqrt+1).append('\n');
    }
}
