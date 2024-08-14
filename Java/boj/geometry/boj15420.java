package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj15420 {
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<Point> points = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }
        Collections.sort(points);

        n = points.size();
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
        int p = 1;

        for(int i=0; i<c; i++) {
            while((p+1)%c != i && width(cvxh.get(i), cvxh.get((i+1)%c), cvxh.get(p)) <= width(cvxh.get(i), cvxh.get((i+1)%c), cvxh.get((p+1)%c))) {
                p = (p+1)%c;
            }
            d = Math.min(d, width(cvxh.get(i), cvxh.get((i+1)%c), cvxh.get(p)));
        }

        bw.write(d+"");
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long res = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Long.compare(res, 0);
    }

    private static double width(Point p1, Point p2, Point p3) {
        double hyp = Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
        double area = Math.abs(p3.x*(p2.y-p1.y)-p3.y*(p2.x-p1.x)+p1.y*p2.x-p1.x*p2.y);
        return area/hyp;
    }

}
