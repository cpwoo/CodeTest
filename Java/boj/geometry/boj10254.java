package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj10254 {
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
        int c = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for(int i=0; i<c; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }
        Collections.sort(points);

        if(c == 2) {
            sb.append(points.get(0).x).append(' ')
            .append(points.get(0).y).append(' ')
            .append(points.get(1).x).append(' ')
            .append(points.get(1).y).append('\n');
            return;
        }

        Stack<Point> stk = new Stack<>();
        for(int i=0; i<c; i++) {
            while(stk.size() > 1 && ccw(stk.get(stk.size()-2), stk.get(stk.size()-1), points.get(i)) <= 0) {
                stk.pop();
            }
            stk.add(points.get(i));
        }

        Stack<Point> revStk = new Stack<>();
        for(int i=c-1; i>=0; i--) {
            while(revStk.size() > 1 && ccw(revStk.get(revStk.size()-2), revStk.get(revStk.size()-1), points.get(i)) <= 0) {
                revStk.pop();
            }
            revStk.add(points.get(i));
        }

        List<Point> cvxh = new ArrayList<>();
        for(int i=0; i<stk.size()-1; i++) cvxh.add(stk.get(i));
        for(int i=0; i<revStk.size()-1; i++) cvxh.add(revStk.get(i));

        double max = 0;
        Point maxDot1 = cvxh.get(0), maxDot2 = cvxh.get(1);

        int n = cvxh.size();

        for(int i=0, j=1; i<n; i++) {
            while(j+1 != i && cccw(cvxh.get(i%n), cvxh.get((i+1)%n), cvxh.get(j%n), cvxh.get((j+1)%n)) > 0) {
                if(dist(cvxh.get(i%n), cvxh.get(j%n)) > max) {
                    max = dist(cvxh.get(i%n), cvxh.get(j%n));
                    maxDot1 = cvxh.get(i%n); maxDot2 = cvxh.get(j%n);
                }
                j++;
            }
            if(dist(cvxh.get(i%n), cvxh.get(j%n)) > max) {
                max = dist(cvxh.get(i%n), cvxh.get(j%n));
                maxDot1 = cvxh.get(i%n); maxDot2 = cvxh.get(j%n);
            }
        }

        sb.append(maxDot1.x).append(' ')
        .append(maxDot1.y).append(' ')
        .append(maxDot2.x).append(' ')
        .append(maxDot2.y).append('\n');
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long res = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Long.compare(res, 0);
    }

    private static int cccw(Point p1, Point p2, Point p3, Point p4) {
        Point tmp = new Point(p4.x, p4.y);
        tmp.x -= (p3.x-p2.x);
        tmp.y -= (p3.y-p2.y);
        return ccw(p1, p2, tmp);
    }

    private static double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }

}
