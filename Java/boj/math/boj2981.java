package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj2981 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        int[] paper = new int[n];
        for(int i=0; i<n; i++) paper[i] = Integer.parseInt(br.readLine());
        Arrays.sort(paper);

        int[] interval = new int[n-1];
        for(int i=0; i<n-1; i++) interval[i] = paper[i+1]-paper[i];

        int prev = interval[0];
        for(int i=1; i<n-1; i++) prev = gcd(prev, interval[i]);

        Set<Integer> ts = new TreeSet<>();
        for(int i=2; i<(int)Math.sqrt(prev)+1; i++) {
            if(prev%i == 0) {
                ts.add(i); ts.add(prev/i);
            }
        }
        ts.add(prev);

        sb = new StringBuilder();
        for(int i : ts) sb.append(i).append(' ');

        bw.write(sb.toString());
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}
