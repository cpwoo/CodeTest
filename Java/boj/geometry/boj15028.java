package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj15028 {
    static class Point implements Comparable<Point> {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if(this.x != point.x) {
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
        int n = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }
        Collections.sort(points);

        Stack<Point> stk = new Stack<>();
        for(int i=0; i<n; i++) {
            while(stk.size() > 1 && ccw(stk.get(stk.size()-2), stk.get(stk.size()-1), points.get(i)) < 0) {
                stk.pop();
            }
            stk.add(points.get(i));
        }

        Stack<Point> revStk = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(revStk.size() > 1 && ccw(revStk.get(revStk.size()-2), revStk.get(revStk.size()-1), points.get(i)) < 0) {
                revStk.pop();
            }
            revStk.add(points.get(i));
        }

        List<Point> cvxh = new ArrayList<>();
        for(int i=0; i<stk.size()-1; i++) cvxh.add(stk.get(i));
        for(int i=0; i<revStk.size()-1; i++) cvxh.add(revStk.get(i));

        double d = Double.POSITIVE_INFINITY;
        int c = cvxh.size();

        for(int i=0; i<c; i++) {
            double tmp = 0.0;
            if(cvxh.get(i).x == cvxh.get((i+1)%c).x) {
                for(int j=0; j<c; j++) {
                    tmp = Math.max(tmp, Math.abs(cvxh.get(i).x-cvxh.get(j).x));
                }
                d = Math.min(d, tmp);
                continue;
            }
            double p = (double) (cvxh.get((i+1)%c).y-cvxh.get(i).y)/(cvxh.get((i+1)%c).x-cvxh.get(i).x);
            double q = -1.0;
            double r = cvxh.get(i).y-p*cvxh.get(i).x;
            for(int j=0; j<c; j++) {
                tmp = Math.max(tmp, Math.abs(p*cvxh.get(j).x+q*cvxh.get(j).y+r)/Math.sqrt(p*p+q*q));
            }
            d = Math.min(d, tmp);
        }

        bw.write(d+"");
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long res = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Long.compare(res, 0);
    }

}
