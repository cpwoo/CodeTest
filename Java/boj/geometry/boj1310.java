package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj1310 {
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
        int n = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }
        Collections.sort(points);

        Stack<Point> down = new Stack<>();
        for (int i=0; i<n; i++) {
            while (down.size() > 1 && ccw(down.get(down.size()-2), down.get(down.size()-1), points.get(i)) <= 0) {
                down.pop();
            }
            down.add(points.get(i));
        }

        Stack<Point> up = new Stack<>();
        for (int i=n-1; i>=0; i--) {
            while (up.size() > 1 && ccw(up.get(up.size()-2), up.get(up.size()-1), points.get(i)) <= 0) {
                up.pop();
            }
            up.add(points.get(i));
        }

        List<Point> cvxh = new ArrayList<>();
        cvxh.addAll(down);
        cvxh.addAll(up);

        int l = 0, r = down.size()-1;
        long maxDist = dist(cvxh.get(l), cvxh.get(r));
        int c = cvxh.size();

        for (int i=0; i<c; i++) {
            Point lp = cvxh.get(l);
            Point nlp = cvxh.get((l+1)%c);
            Point rp = cvxh.get(r);
            Point nrp = cvxh.get((r+1)%c);

            if (ccw(new Point(nlp.x-lp.x, nlp.y-lp.y),
                    new Point(0, 0),
                    new Point(nrp.x-rp.x, nrp.y - rp.y)) > 0) {
                l = (l+1)%c;
            } else {
                r = (r+1)%c;
            }

            maxDist = Math.max(maxDist, dist(cvxh.get(l), cvxh.get(r)));
        }

        bw.write(maxDist+"");
    }

    private static long dist(Point p1, Point p2) {
        return (p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y);
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long result = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Long.compare(result, 0);
    }

}
