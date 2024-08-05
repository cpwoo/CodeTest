package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2618 {
    static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int N, W, dp[][];
    private static List<Position> pos;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        pos = new ArrayList<>();
        pos.add(new Position(1, 1));
        pos.add(new Position(N, N));

        for(int i=0; i<W; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos.add(new Position(x, y));
        }

        dp = new int[W+2][W+2];
        for(int i=0; i<W+2; i++) Arrays.fill(dp[i], -1);

        sb = new StringBuilder();
        sb.append(dist(0, 1)).append('\n');

        backtracking(0, 1);

        bw.write(sb.toString());
    }

    private static int dist(int i, int j) {
        if(i > W || j > W) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int tmp = Math.max(i, j)+1;
        int ni = dist(tmp, j)+Math.abs(pos.get(tmp).x-pos.get(i).x)+Math.abs(pos.get(tmp).y-pos.get(i).y);
        int nj = dist(i, tmp)+Math.abs(pos.get(tmp).x-pos.get(j).x)+Math.abs(pos.get(tmp).y-pos.get(j).y);

        return dp[i][j] = Math.min(ni, nj);
    }

    private static void backtracking(int i, int j) {
        if(i > W || j > W) return;
        int nc = Math.max(i, j)+1;
        int ni = Math.abs(pos.get(nc).x-pos.get(i).x)+Math.abs(pos.get(nc).y-pos.get(i).y);
        int nj = Math.abs(pos.get(nc).x-pos.get(j).x)+Math.abs(pos.get(nc).y-pos.get(j).y);

        if(dp[nc][j]+ni < dp[i][nc]+nj) {
            sb.append('1').append('\n');
            backtracking(nc, j);
        } else {
            sb.append('2').append('\n');
            backtracking(i, nc);
        }
    }

}
