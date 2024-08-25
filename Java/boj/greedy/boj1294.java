package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1294 {
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
        
        PriorityQueue<String> q = new PriorityQueue<>();
        for(int i=0; i<n; i++) q.add(br.readLine()+'z');

        sb = new StringBuilder();
        while(!q.isEmpty()) {
            String s = q.poll();
            sb.append(s.charAt(0));
            if(s.length() > 2) q.add(s.substring(1, s.length()));
        }

        bw.write(sb.toString());
    }

}
