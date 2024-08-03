package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1943 {
    static class Coin implements Comparable<Coin> {
        int val, ea;
        Coin(int val, int ea) {
            this.val = val;
            this.ea = ea;
        }

        @Override
        public int compareTo(Coin coin) {
            if(this.val != coin.val) {
                return this.val-coin.val;
            }
            return this.ea-coin.ea;
        }
    }

    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        for(int i=0; i<3; i++) solve();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int[] dp = new int[50001];
        dp[0] = 1;

        int n = Integer.parseInt(br.readLine());

        List<Coin> coins = new ArrayList<>();
        int tot = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tot += a*b;
            coins.add(new Coin(a, b));
        }
        Collections.sort(coins);
        
        if(tot%2 == 1) {
            sb.append(0).append('\n');
            return;
        }

        int half = tot/2;

        for(Coin coin : coins) {
            for(int i=half; i>=coin.val; i--) {
                if(dp[i-coin.val] != 0) {
                    for(int j=0; j<coin.ea; j++) {
                        if(i+j*coin.val > half) break;
                        dp[i+j*coin.val] = 1;
                    }
                }
            }
        }

        sb.append(dp[half]).append('\n');
    }

}
