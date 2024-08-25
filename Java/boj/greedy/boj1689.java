package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1689 {
    static class Line implements Comparable<Line> {
        int s, e;
        Line(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Line line) {
            if(this.s != line.s) return this.s-line.s;
            return this.e-line.e;
        }
    }

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
        int n = Integer.parseInt(br.readLine());
        
        Queue<Line> lines = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines.add(new Line(s, e));
        }

        Queue<Integer> q = new PriorityQueue<>();
        q.add(lines.poll().e);
        
        int ret = 1;
        while(!lines.isEmpty()) {
            Line line = lines.poll();
            while(!q.isEmpty() && q.peek() <= line.s) q.poll();
            q.add(line.e);
            ret = Math.max(ret, q.size());
        }

        bw.write(ret+"");
    }

}
