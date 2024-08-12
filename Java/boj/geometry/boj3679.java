package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj3679 {
    static class Point implements Comparable<Point> {
        int x, y, idx;
        Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point point) {
            if(this.x != point.x) {
                return this.x-point.x;
            }
            else if(this.y != point.y) {
                return this.y-point.y;
            }
            return this.idx-point.idx;
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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        List<Point> points = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y, i));
        }
        Collections.sort(points);

        boolean[] v = new boolean[n];
        Stack<Point> stk = new Stack<>();
        
        for(int i=0; i<n; i++) {
            while(stk.size() > 1 && ccw(stk.get(stk.size()-2), stk.get(stk.size()-1), points.get(i)) < 0) {
                v[stk.pop().idx] = false;
            }
            stk.add(points.get(i));
            v[points.get(i).idx] = true;
        }

        for(Point point : points) if(!v[point.idx]) sb.append(point.idx).append(' ');

        while(!stk.isEmpty()) sb.append(stk.pop().idx).append(' ');

        sb.append('\n');
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long res = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Long.compare(res, 0);
    }

}
