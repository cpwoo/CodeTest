package CodeTest.Java.boj.string;

import java.io.*;

public class boj16500 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static String str, a[];
    private static int L, n, dp[], ret;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        str = br.readLine();
        L = str.length();

        n = Integer.parseInt(br.readLine());
        a = new String[n];
        for(int i=0; i<n; i++) a[i] = br.readLine();
        dp = new int[101];

        ret = 0;
        dfs(0);

        bw.write(ret+"");
    }

    private static void dfs(int idx) {
        if(idx == L) {
            ret = 1;
            return;
        }

        if(dp[idx] != 0) return;

        dp[idx] = 1;

        for(int i=0; i<n; i++) {
            if(L-idx >= a[i].length()) {
                boolean flag = true;
                for(int j=0; j<a[i].length(); j++) {
                    if(a[i].charAt(j) != str.charAt(idx+j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) dfs(idx+a[i].length());
            }
        }

        return;
    }

}
