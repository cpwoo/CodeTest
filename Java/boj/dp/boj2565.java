package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2565 {
    static class Line implements Comparable<Line> {
        int a, b;
        Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line line) {
            if(this.a != line.a) {
                return this.a-line.a;
            }
            return this.b-line.b;
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
        List<Line> arr = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Line(x, y));
        }

        Collections.sort(arr);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr.get(i).b > arr.get(j).b) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) max = Math.max(max, dp[i]);

        bw.write(n-max+"");
    }

}
