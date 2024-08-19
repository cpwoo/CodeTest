package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj11067 {
    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

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
        List<Point> points = new ArrayList<>();

        List<Integer> cafe[] = new ArrayList[100001];
        for(int i=0; i<100001; i++) cafe[i] = new ArrayList<>();

        int lim = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lim = Math.max(x, lim);
            cafe[x].add(y);
        }

        for(int i=0; i<lim+1; i++) {
            if(i == 0) Collections.sort(cafe[0], (o1, o2) -> Integer.compare(Math.abs(o1), Math.abs(o2)));
            else {
                Point last = points.get(points.size()-1);
                Collections.sort(cafe[i], (o1, o2) -> Integer.compare(Math.abs(last.c-o1), Math.abs(last.c-o2)));
            }
            for(int c : cafe[i]) {
                points.add(new Point(i, c));
            }
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(points.get(num-1).r).append(' ').append(points.get(num-1).c).append('\n');
        }
    }

}
