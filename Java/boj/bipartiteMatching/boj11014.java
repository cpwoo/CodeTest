package CodeTest.Java.boj.bipartiteMatching;

import java.io.*;
import java.util.*;

public class boj11014 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int[] dx = new int[]{0, 0, -1, -1, 1, 1};
    private static int[] dy = new int[]{-1, 1, -1, 1, -1, 1};

    private static int n, m, connect[][][];
    private static boolean check[][], v[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {

        int T = Integer.parseInt(br.readLine());

        for(int k=0; k<T; k++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            char[][] board = new char[n][m];
            for(int i=0; i<n; i++) {
                board[i] = br.readLine().toCharArray();
            }

            check = new boolean[n][m];

            int ret = 0;
            for(int x=0; x<n; x++) {
                for(int y=0; y<m; y++) {
                    if(board[x][y] == '.') {
                        check[x][y] = true;
                        ret++;
                    }
                }
            }

            connect = new int[n][m][2];
            for(int x=0; x<n; x++) {
                for(int y=0; y<m; y++) {
                    Arrays.fill(connect[x][y], -1);
                }
            }

            for(int x=0; x<n; x++) {
                for(int y=0; y<m; y+=2) {
                    if(check[x][y]) {
                        v = new boolean[n][m];
                        if(bipartiteMatching(x, y)) ret--;
                    }
                }
            }

            bw.write(ret+"\n");
        }
    }

    private static boolean bipartiteMatching(int x, int y) {
        for(int d=0; d<6; d++) {
            int nx = x+dx[d], ny = y+dy[d];
            if(0 <= nx && nx < n && 0 <= ny && ny < m && !v[nx][ny] && check[nx][ny]) {
                v[nx][ny] = true;
                int p = connect[nx][ny][0];
                int q = connect[nx][ny][1];
                if((p == -1 && q == -1) || bipartiteMatching(p, q)) {
                    connect[nx][ny][0] = x;
                    connect[nx][ny][1] = y;
                    return true;
                }
            }
        }
        return false;
    }

}
