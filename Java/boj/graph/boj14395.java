package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj14395 {
    static class Calc {
        int x; StringBuilder op;
        Calc(int x, StringBuilder op) {
            this.x = x;
            this.op = op;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int max = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        if(s == t) {
            bw.write("0");
            return;
        }

        Deque<Calc> q = new ArrayDeque<>();
        q.add(new Calc(s, new StringBuilder()));

        Set<Integer> visited = new HashSet<>();
        visited.add(s);

        while(!q.isEmpty()) {
            Calc calc = q.poll();
            if(calc.x == t) {
                bw.write(calc.op.toString());
                return;
            }

            if(0 <= calc.x && calc.x <= Math.sqrt(max) && !visited.contains(calc.x*calc.x)) {
                q.add(new Calc(calc.x*calc.x, new StringBuilder(calc.op).append('*')));
                visited.add(calc.x*calc.x);
            }

            if(0 <= calc.x && calc.x <= max/2 && !visited.contains(calc.x+calc.x)) {
                q.add(new Calc(calc.x+calc.x, new StringBuilder(calc.op).append('+')));
                visited.add(calc.x+calc.x);
            }

            if(!visited.contains(1)) {
                q.add(new Calc(1, new StringBuilder(calc.op).append('/')));
                visited.add(1);
            }
        }

        bw.write("-1");
    }

}
