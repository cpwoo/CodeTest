package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj15922 {
    static class Point implements Comparable<Point> {
        int from, to;
        Point(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Point point) {
            if(this.from != point.from) return this.from-point.from;
            return this.to-point.to;
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

        List<Point> lst = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lst.add(new Point(a, b));
        }

        Collections.sort(lst);

        long ret = 0;
        int start = lst.get(0).from, end = lst.get(0).to;
        for(int i=1; i<n; i++) {
            if(lst.get(i).from <= end) {
                if(lst.get(i).to > end) end = lst.get(i).to;
            }
            else {
                ret += end-start;
                start = lst.get(i).from; end = lst.get(i).to;
            }
        }

        ret += end-start;

        bw.write(ret+"");
    }

}
