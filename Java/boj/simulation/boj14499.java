package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj14499 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};

    private static int[] dice;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dice = new int[6];

        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int nx = x, ny = y;
        for(int i=0; i<k; i++) {
            int c = Integer.parseInt(st.nextToken())-1;
            nx += dx[c]; ny += dy[c];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                nx -= dx[c]; ny -= dy[c];
                continue;
            }

            turn(c);

            if(board[nx][ny] == 0) board[nx][ny] = dice[5];
            else {
                dice[5] = board[nx][ny];
                board[nx][ny] = 0;
            }

            sb.append(dice[0]).append('\n');
        }

        bw.write(sb.toString());
    }

    private static void turn(int dir) {
        int a = dice[0], b = dice[1], c = dice[2], d = dice[3], e = dice[4], f = dice[5];

        switch(dir) {
            case 0: {
                dice[0] = d; dice[1] = b; dice[2] = a; dice[3] = f; dice[4] = e; dice[5] = c;
                break;
            }
            case 1: {
                dice[0] = c; dice[1] = b; dice[2] = f; dice[3] = a; dice[4] = e; dice[5] = d;
                break;
            }
            case 2: {
                dice[0] = e; dice[1] = a; dice[2] = c; dice[3] = d; dice[4] = f; dice[5] = b;
                break;
            }
            case 3: {
                dice[0] = b; dice[1] = f; dice[2] = c; dice[3] = d; dice[4] = a; dice[5] = e;
                break;
            }
        }
    }
}
