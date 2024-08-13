package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj10839 {
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
        int n = Integer.parseInt(br.readLine());

        long[][] points = new long[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Long.parseLong(st.nextToken());
            points[i][1] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int fr = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        if((fr-to)%n == 1 || (fr-to)%n == n-1) {
            sb = new StringBuilder();
            sb.append("2\n").append(fr).append(' ').append(to).append('\n');
            bw.write(sb.toString());
            return;
        }

        boolean flag = false;
        if((fr == 0) || (to != 0 && fr > to)) {
            flag = true;
            int tmp = fr;
            fr = to;
            to = tmp;
        }

        Stack<Integer> stk = new Stack<>();
        for(int i=fr; i<fr+n; i++) {
            i %= n;
            while(stk.size() > 1 && ccw(points[stk.get(stk.size()-2)], points[stk.get(stk.size()-1)], points[i]) >= 0) {
                stk.pop();
            }
            stk.add(i);

            if(i == to) break;
        }

        int c = stk.size();

        sb = new StringBuilder();
        sb.append(stk.size()).append('\n');

        for(int i=0; i<c; i++) {
            sb.append(flag ? stk.get(c-i-1) : stk.get(i)).append(' ');
        }

        bw.write(sb.toString());
    }

    private static int ccw(long[] p1, long[] p2, long[] p3) {
        long res = (p1[0]*p2[1]+p2[0]*p3[1]+p3[0]*p1[1])-(p1[1]*p2[0]+p2[1]*p3[0]+p3[1]*p1[0]);
        return Long.compare(res, 0);
    }

}
