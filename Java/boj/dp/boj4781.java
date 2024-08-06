package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj4781 {
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
        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int) Math.round(Double.parseDouble(st.nextToken())*100);

            if(n == 0) break;


            List<int[]> arr = new ArrayList<>();
            arr.add(new int[]{0, 0});

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = (int) Math.round(Double.parseDouble(st.nextToken())*100);
                arr.add(new int[]{a, b});
            }

            int[][] dp = new int[n+1][m+1];

            for(int i=1; i<n+1; i++) {
                for(int j=0; j<m+1; j++) {
                    if(j-arr.get(i)[1] >= 0) {
                        dp[i][j] = Math.max(dp[i][j-arr.get(i)[1]]+arr.get(i)[0], dp[i-1][j]);
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

            sb.append(dp[n][m]).append('\n');
        }

        bw.write(sb.toString());
    }

}
