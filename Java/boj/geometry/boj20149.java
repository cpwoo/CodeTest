package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj20149 {
    static class Point implements Comparable<Point> {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double cross(Point point) {
            return this.x*point.y-this.y*point.x;
        }

        boolean equals(Point point) {
            return this.x == point.x && this.y == point.y;
        }

        @Override
        public int compareTo(Point point) {
            if(x != point.x) return Double.compare(x, point.x);
            return Double.compare(y, point.y);
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
        Point p1 = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        Point p2 = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point p3 = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        Point p4 = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        if(p1.compareTo(p2) > 0) {
            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        } 

        if(p3.compareTo(p4) > 0) {
            Point tmp = p3;
            p3 = p4;
            p4 = tmp;
        }

        if(check(p1, p2, p3, p4)) {
            bw.write("1\n");
            if((p1.x-p2.x)*(p3.y-p4.y)-(p1.y-p2.y)*(p3.x-p4.x) != 0) {
                double a = (p1.cross(p2)*(p3.x-p4.x)-(p1.x-p2.x)*p3.cross(p4))/((p1.x-p2.x)*(p3.y-p4.y)-(p1.y-p2.y)*(p3.x-p4.x));
                double b = (p1.cross(p2)*(p3.y-p4.y)-(p1.y-p2.y)*p3.cross(p4))/((p1.x-p2.x)*(p3.y-p4.y)-(p1.y-p2.y)*(p3.x-p4.x));
                bw.write(a+" "+b+"");
            }
            else {
                if(p2.equals(p3)) bw.write(p2.x+" "+p2.y+"");
                else if(p1.equals(p4)) bw.write(p1.x+" "+p1.y+"");
            }
        }
        else {
            bw.write("0\n");
        }
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        double res = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Double.compare(res, 0);
    }

    private static boolean check(Point p1, Point p2, Point p3, Point p4) {
        if(ccw(p1,p2,p3)*ccw(p1,p2,p4) == 0 && ccw(p3,p4,p1)*ccw(p3,p4,p2) == 0) {
            return p2.compareTo(p3) >= 0 && p1.compareTo(p4) <= 0;
        }
        return ccw(p1,p2,p3)*ccw(p1,p2,p4) <= 0 && ccw(p3,p4,p1)*ccw(p3,p4,p2) <= 0;
    }

}
