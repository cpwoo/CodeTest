package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj1708 {
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

        int ret = -2;
        Collections.sort(points);
        ret += convexHull(points);

        Collections.sort(points, Collections.reverseOrder());
        ret += convexHull(points);
        
        bw.write(ret+"");
    }

    private static int convexHull(List<Point> points) {
        Stack<Point> convex = new Stack<>();

        for(Point p3 : points) {
            while(convex.size() >= 2) {
                if(ccw(convex.get(convex.size()-2), convex.get(convex.size()-1), p3)) break;
                convex.pop();
            }
            convex.add(p3);
        }

        return convex.size();
    }

    private static boolean ccw(Point p1, Point p2, Point p3) {
        return (p2.x-p1.x)*(p3.y-p2.y) > (p2.y-p1.y)*(p3.x-p2.x);
    }

}
