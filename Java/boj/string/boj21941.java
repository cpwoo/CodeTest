package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj21941 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static String str;
    private static int n, dp[];
    private static Map<String, Integer> map;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        str = br.readLine();
        n = str.length();

        map = new HashMap<>();

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            String string = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            map.put(string, score);
        }

        dp = new int[n+1];
        Arrays.fill(dp, -1);

        bw.write(dfs(0)+"");
    }

    private static int dfs(int idx) {
        if(idx >= n) return 0;

        if(dp[idx] != -1) return dp[idx];

        int maxValue = 0;

        for(String key : map.keySet()) {
            int score = map.get(key), len = key.length();

            if(idx+len-1 < n) {
                boolean flag = true;
                for(int chkIdx=0; chkIdx<len; chkIdx++) {
                    if(str.charAt(chkIdx+idx) != key.charAt(chkIdx)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) maxValue = Math.max(maxValue, score+dfs(idx+len));
            }
        }

        maxValue = Math.max(maxValue, 1+dfs(idx+1));

        return dp[idx] = maxValue;
    }

}
