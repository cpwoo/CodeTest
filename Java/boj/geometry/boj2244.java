package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj2244 {
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
    private static StringBuilder sb;

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
        int m = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] B = new int[m][2];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Point> points = new ArrayList<>();
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            points.add(new Point(A[i][0]+B[j][0], A[i][1]+B[j][1]));
        }
        Collections.sort(points);

        int L = points.size();

        Stack<Point> down = new Stack<>();
        for (int i=0; i<L; i++) {
            while (down.size() > 1 && ccw(down.get(down.size()-2), down.get(down.size()-1), points.get(i)) <= 0) {
                down.pop();
            }
            down.add(points.get(i));
        }

        Stack<Point> up = new Stack<>();
        for (int i=L-1; i>=0; i--) {
            while (up.size() > 1 && ccw(up.get(up.size()-2), up.get(up.size()-1), points.get(i)) <= 0) {
                up.pop();
            }
            up.add(points.get(i));
        }

        List<Point> cvxh = new ArrayList<>();
        for(int i=0; i<down.size()-1; i++) cvxh.add(down.get(i));
        for(int i=0; i<up.size()-1; i++) cvxh.add(up.get(i));

        sb = new StringBuilder();
        sb.append(cvxh.size()).append('\n');

        for(Point p : cvxh) sb.append(p.x).append(' ').append(p.y).append('\n');

        bw.write(sb.toString());
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long result = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Long.compare(result, 0);
    }

}
