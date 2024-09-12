package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj4179 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

    private static int r, c, ret;
    private static char board[][];

    private static Deque<int[]> F, J, tmp;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        F = new ArrayDeque<>(); J = new ArrayDeque<>();
        for(int i=0; i<r; i++) {
            board[i] = br.readLine().toCharArray();
            for(int j=0; j<c; j++) {
                if(board[i][j] == 'F') F.add(new int[]{i, j});
                if(board[i][j] == 'J') J.add(new int[]{i, j});
            }
        }

        ret = 0;
        bw.write((bfs()) ? ret+"" : "IMPOSSIBLE");
    }

    private static boolean bfs() {
        while(true) {
            ret++;
            tmp = new ArrayDeque<>();
            while(!F.isEmpty()) {
                int[] cur = F.poll();
                int x = cur[0], y = cur[1];

                for(int i=0; i<4; i++) {
                    int nx = x+dx[i], ny = y+dy[i];
                    if(0 <= nx && nx < r && 0 <= ny && ny < c) {
                        if(board[nx][ny] == '.' || board[nx][ny] == '$') {
                            tmp.add(new int[]{nx, ny});
                            board[nx][ny] = 'F';
                        }
                    }
                }
            }
            F = tmp;

            tmp = new ArrayDeque<>();
            while(!J.isEmpty()) {
                int[] cur = J.poll();
                int x = cur[0], y = cur[1];
                if(x == 0 || y == 0 || x == r-1 || y == c-1) return true;

                for(int i=0; i<4; i++) {
                    int nx = x+dx[i], ny = y+dy[i];
                    if(0 <= nx && nx < r && 0 <= ny && ny < c) {
                        if(board[nx][ny] == '.') {
                            tmp.add(new int[]{nx, ny});
                            board[x][y] = '$';
                            board[nx][ny] = 'J';
                        }
                    }
                }
            }
            J = tmp;

            if(J.isEmpty()) return false;
        }
    }

}
