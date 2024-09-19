package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj10836 {
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
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] grow = new int[2*m-1];
        Arrays.fill(grow, 1);

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            st.nextToken();

            for(int j=a; j<a+b; j++) grow[j]++;
            for(int j=a+b; j<2*m-1; j++) grow[j] += 2;
        }

        StringBuilder s = new StringBuilder();
        for(int i=m; i<2*m-1; i++) s.append(grow[i]).append(' ');

        sb = new StringBuilder();
        for(int i=m-1; i>=0; i--) {
            sb.append(grow[i]).append(' ').append(s).append('\n');
        }

        bw.write(sb.toString());
    }

}
