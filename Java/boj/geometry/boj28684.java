package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj28684 {
    static class Point implements Comparable<Point> {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if(this.x != point.x) return Double.compare(this.x, point.x);
            return Double.compare(this.y, point.y);
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
        Stack<Point> points = new Stack<>();

        points.add(new Point(0, 0));
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            points.add(new Point(i+1, points.peek().y+Integer.parseInt(st.nextToken())));
        }

        Collections.reverse(points);
        
        Stack<Point> up = new Stack<>();
        for(Point pt : points) {
            while(up.size() > 1 && ccw(up.get(up.size()-2), up.get(up.size()-1), pt) < 0) {
                up.pop();
            }
            up.add(pt);
        }

        Collections.sort(up);

        Stack<Point> ret = new Stack<>();
        ret.add(new Point(0, 0));

        for(int i=1; i<up.size(); i++) {
            Point np = up.get(i);
            double nx = np.x, ny = np.y;
            double x = ret.peek().x, y = ret.peek().y;

            double dx = nx-x, dy = ny-y;

            for(long j=(long)x+1; j<nx+1; j++) {
                ret.add(new Point(j, y+dy/(dx)*(j-x)));
            }
        }

        boolean flag = true;
        for(int i=0; i<n+1; i++) {
            double r = ret.get(i).y, p = points.get(points.size()-i-1).y;
            if(r-p < 0 || r-p >= 1) {
                flag = false;
                break;
            }
        }

        bw.write(flag ? "Not Provable" : "Provable");
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        double res = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Double.compare(res, 0);
    }

}
