package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2643 {
    static class Paper implements Comparable<Paper> {
        int a, b;
        Paper(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Paper paper) {
            if(this.a != paper.a) {
                return this.a-paper.a;
            }
            return this.b-paper.b;
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

        List<Paper> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Paper(Math.min(a,b), Math.max(a,b)));
        }
        Collections.sort(arr);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr.get(j).b <= arr.get(i).b) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) max = Math.max(max, dp[i]);

        bw.write(max+"");
    }

}
