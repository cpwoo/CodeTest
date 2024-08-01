package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1099 {
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
        String str = br.readLine();
        int L = str.length();
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for(int i=0; i<n; i++) words[i] = br.readLine();

        final int MAX = 2500;
        int[] dp = new int[L+1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for(int i=1; i<L+1; i++) {
            for(int j=0; j<i; j++) {
                String tmp = str.substring(j, i);
                for(int k=0; k<n; k++) {
                    if(check(words[k], tmp)) {
                        dp[i] = Math.min(dp[i], dp[j]+cal(words[k], tmp));
                    }
                }
            }
        }

        bw.write((dp[L] == MAX) ? "-1" : dp[L]+"");
    }

    private static int cal(String a, String b) {
        int cnt = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt;
    }

    private static boolean check(String a, String b) {
        if(a.length() == b.length()) {
            int[] counter = new int[26];
            for(int i=0; i<a.length(); i++) {
                counter[a.charAt(i)-'a']++;
                counter[b.charAt(i)-'a']--;
            }
            for(int i=0; i<26; i++) {
                if(counter[i] != 0) return false;
            }
            return true;
        }
        return false;
    }

}
