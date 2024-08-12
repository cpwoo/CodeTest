package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj2699 {
    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if(this.y != point.y) {
                return point.y-this.y;
            }
            return this.x-point.x;
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
        for(int i=0; i<(n-1)/5+1; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points.add(new Point(x, y));
            }
        }
        Collections.sort(points);

        Stack<Point> stk = new Stack<>();
        for(int i=0; i<n; i++) {
            while(stk.size() > 1 && ccw(stk.get(stk.size()-2), stk.get(stk.size()-1), points.get(i)) <= 0) {
                stk.pop();
            }
            stk.add(points.get(i));
        }

        Stack<Point> revStk = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(revStk.size() > 1 && ccw(revStk.get(revStk.size()-2), revStk.get(revStk.size()-1), points.get(i)) <= 0) {
                revStk.pop();
            }
            revStk.add(points.get(i));
        }

        List<Point> cvxh = new ArrayList<>();
        
        while(revStk.size() > 1) cvxh.add(revStk.pop());
        while(stk.size() > 1) cvxh.add(stk.pop());
        
        sb.append(cvxh.size()).append('\n');
        for(Point c : cvxh) {
            sb.append(c.x).append(' ').append(c.y).append('\n');
        }
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long res = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Long.compare(res, 0);
    }

}
