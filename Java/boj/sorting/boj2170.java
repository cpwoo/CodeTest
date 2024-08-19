package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj2170 {
    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int a) {
            this.x = x;
            this.y = a;
        }

        @Override
        public int compareTo(Point point) {
            if(this.x != point.x) return this.x-point.x;
            return this.y-point.y;
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
        
        List<Point> lst = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lst.add(new Point(x, y));
        }

        Collections.sort(lst);

        int left = lst.get(0).x, right = lst.get(0).y;

        long answer = 0;

        for(int i=1; i<n; i++) {
            if(lst.get(i).y <= right) continue;
            else if(lst.get(i).x <= right && right < lst.get(i).y) right = lst.get(i).y;
            else if(right < lst.get(i).x) {
                answer += right-left;
                left = lst.get(i).x; right = lst.get(i).y;
            }
        }

        answer += right-left;
        bw.write(answer+"");
    }

}
