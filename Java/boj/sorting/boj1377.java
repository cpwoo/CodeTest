package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj1377 {
    static class Point implements Comparable<Point> {
        int x, idx;
        Point(int x, int idx) {
            this.x = x;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point point) {
            return this.x-point.x;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;

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
            lst.add(new Point(Integer.parseInt(br.readLine()), i));
        }

        List<Point> sortedLst = new ArrayList<>(lst);
        Collections.sort(sortedLst);

        int[] answer = new int[n];
        for(int i=0; i<n; i++) answer[i] = sortedLst.get(i).idx-lst.get(i).idx;
        
        int max = 0;
        for(int i=0; i<n; i++) max = Math.max(max, answer[i]);

        bw.write(max+1+"");
    }

}
