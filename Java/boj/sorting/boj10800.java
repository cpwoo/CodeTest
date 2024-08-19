package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj10800 {
    static class Ball implements Comparable<Ball> {
        int c, s, idx;
        Ball(int c, int s, int idx) {
            this.c = c;
            this.s = s;
            this.idx = idx;
        }

        @Override
        public int compareTo(Ball ball) {
            return this.s-ball.s;
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
        int n = Integer.parseInt(br.readLine());

        List<Ball> balls = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls.add(new Ball(c, s, i));
        }
        Collections.sort(balls);

        int[] answer = new int[n+1];
        int[] ballSizeSum = new int[n+1];

        int total = 0;
        for(int i=0, j=0; i<n; i++) {
            while(balls.get(j).s < balls.get(i).s) {
                total += balls.get(j).s;
                ballSizeSum[balls.get(j).c] += balls.get(j).s;
                j++;
            }
            answer[balls.get(i).idx] = total-ballSizeSum[balls.get(i).c];
        }

        sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(answer[i]).append('\n');

        bw.write(sb.toString());
    }

}
