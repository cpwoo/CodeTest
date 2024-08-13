package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj3878 {
    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if(this.x != point.x) {
                return this.x-point.x;
            }
            return this.y-point.y;
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
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        List<Point> black = new ArrayList<>();
        for(int i=0; i<b; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            black.add(new Point(x, y));
        }

        List<Point> white = new ArrayList<>();
        for(int i=0; i<w; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            white.add(new Point(x, y));
        }

        List<Point> cvxhBlack = init(black);
        List<Point> cvxhWhite = init(white);

        b = cvxhBlack.size(); w = cvxhWhite.size();

        if(b < 3 && w < 3) {
            sb.append((crossCheck(cvxhBlack.get(0), cvxhBlack.get(1%b), cvxhWhite.get(0), cvxhWhite.get(1%w))) ? "NO" : "YES").append('\n');
            return;
        }

        int[] ccw1Cnt = {0, 0}, ccw2Cnt = {0, 0};

        boolean flag = true;
        for(int i=0; i<b; i++) {
            for(int j=0; j<w; j++) {
                int ccw1 = ccw(cvxhBlack.get(i), cvxhWhite.get(j), cvxhWhite.get((j+1)%w));
                int ccw2 = ccw(cvxhWhite.get(j), cvxhBlack.get(i), cvxhBlack.get((i+1)%b));

                if(ccw1 > 0) ccw1Cnt[0]++;
                else if(ccw1 < 0) ccw1Cnt[1]++;
                if(ccw2 > 0) ccw2Cnt[0]++;
                else if(ccw2 < 0) ccw2Cnt[1]++;

                if(crossCheck(cvxhBlack.get(i), cvxhBlack.get((i+1)%b), cvxhWhite.get(j), cvxhWhite.get((j+1)%w))) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }

        if(Math.max(ccw1Cnt[0], ccw1Cnt[1]) == b*w || Math.max(ccw2Cnt[0], ccw2Cnt[1]) == b*w) flag = false;

        sb.append((flag) ? "YES" : "NO").append('\n');
    }

    private static List<Point> init(List<Point> points) {
        int n = points.size();

        if(n <= 1) {
            return points;
        }

        Collections.sort(points);

        Stack<Point> lower = new Stack<>();
        Stack<Point> upper = new Stack<>();
        for(int i=0; i<n; i++) {
            int j = n-1-i;
            while(lower.size() > 1 && ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), points.get(i)) <= 0) {
                lower.pop();
            }
            lower.add(points.get(i));
            while(upper.size() > 1 && ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), points.get(j)) <= 0) {
                upper.pop();
            }
            upper.add(points.get(j));
        }

        List<Point> ret = new ArrayList<>();
        for(int i=0; i<lower.size()-1; i++) ret.add(lower.get(i));
        for(int i=0; i<upper.size()-1; i++) ret.add(upper.get(i));

        return ret;
    }

    private static boolean crossCheck(Point p1, Point p2, Point p3, Point p4) {
        int a = ccw(p1, p2, p3), b = ccw(p1, p2, p4), c = ccw(p3, p4, p1), d = ccw(p3, p4, p2);
                
        if(a*b <= 0 && c*d <= 0) {
            if(a*b == 0 && c*d == 0) {
                if(Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) && Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y)
                && Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x) && Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y)) {
                    return true;
                }
            }
            else return true;
        }

        return false;
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long res = (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
        return Long.compare(res, 0);
    }

}
