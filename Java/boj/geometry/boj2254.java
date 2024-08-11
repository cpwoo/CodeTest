package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj2254 {
    static class Point implements Comparable<Point> {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if (this.x != point.x) {
                return Long.compare(this.x, point.x);
            }
            return Long.compare(this.y, point.y);
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int px = Integer.parseInt(st.nextToken());
        int py = Integer.parseInt(st.nextToken());

        Point p = new Point(px, py);

        List<Point> points = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        int ret = 0;

        while(points.size() >= 3) {
            Collections.sort(points);
            Stack<Point> stk = new Stack<>();
            for(Point pt : points) {
                while(stk.size() > 1 && ccw(stk.get(stk.size()-2), stk.get(stk.size()-1), pt) < 0) {
                    stk.pop();
                }
                stk.add(pt);
            }

            Collections.sort(points, Collections.reverseOrder());
            Stack<Point> revStk = new Stack<>();
            for(Point pt : points) {
                while(revStk.size() > 1 && ccw(revStk.get(revStk.size()-2), revStk.get(revStk.size()-1), pt) <= 0) {
                    revStk.pop();
                }
                revStk.add(pt);
            }

            List<Point> cvxh = new ArrayList<>();
            for(int i=0; i<stk.size()-1; i++) cvxh.add(stk.get(i));
            for(int i=0; i<revStk.size()-1; i++) cvxh.add(revStk.get(i));

            boolean flag = true;
            for(int i=0; i<cvxh.size(); i++) {
                int ni = (i+1)%cvxh.size();
                if(ccw(cvxh.get(i), cvxh.get(ni), p) <= 0) {
                    flag = false;
                    break;
                }
            }

            if(!flag) break;
            ret++;

            for(Point c : cvxh) points.remove(c);
        }

        bw.write(ret+"");
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long result = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Long.compare(result, 0);
    }

}
