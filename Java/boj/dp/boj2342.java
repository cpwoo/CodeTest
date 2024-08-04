package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2342 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Integer> move;
    private static int n, dp[][][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        move = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        while(true) {
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) break;
            move.add(x);
        }

        n = move.size();
        if(n == 0) {
            bw.write('0');
            return;
        }

        dp = new int[n+1][5][5];
        for(int i=0; i<n+1; i++) for(int j=0; j<5; j++) {
            Arrays.fill(dp[i][j], -1);
        }

        bw.write(dfs(0, 0, 0)+"");
    }

    private static int dfs(int cnt, int left, int right) {
        if(cnt == n) return 0;

        if(dp[cnt][left][right] != -1) return dp[cnt][left][right];

        return dp[cnt][left][right] = Math.min(
            dfs(cnt+1, move.get(cnt), right)+getAdd(move.get(cnt), left),
            dfs(cnt+1, left, move.get(cnt))+getAdd(move.get(cnt), right)
        );
    }

    private static int getAdd(int lr, int k) {
        if(k == 0) return (lr == 0) ? 0 : 2;
        else if(k == lr) return 1;
        else if(Math.abs(k-lr) == 1 || Math.abs(k-lr) == 3) return 3;
        else return 4;
    }

}
