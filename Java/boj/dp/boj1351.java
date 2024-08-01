package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1351 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static long N, P, Q;
    private static Map<Long, Long> dp;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        dp = new HashMap<>();
        dp.put(0L, 1L);

        bw.write(dfs(N)+"");
    }

    private static long dfs(long x) {
        if(dp.containsKey(x)) return dp.get(x);

        dp.put(x, dfs(x/P)+dfs(x/Q));

        return dp.get(x);
    }

}
