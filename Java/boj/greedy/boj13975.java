package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj13975 {
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
        int n = Integer.parseInt(br.readLine());
        
        Queue<Long> q = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) q.add(Long.parseLong(st.nextToken()));

        long ret = 0;
        while(q.size() > 1) {
            long a = q.poll();
            long b = q.poll();
            ret += a+b;
            q.add(a+b);
        }

        sb.append(ret).append('\n');
    }
}
