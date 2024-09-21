package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj19236 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,-1,0,1,1,1,0,-1};
    private static final int[] dy = {0,-1,-1,-1,0,1,1,1};

    private static int max;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int[][][] board = new int[4][4][2];
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                board[i][j][0] = Integer.parseInt(st.nextToken());
                board[i][j][1] = Integer.parseInt(st.nextToken())-1;
            }
        }

        max = 0;

        dfs(0, 0, 0, board);

        bw.write(max+"");
    }

    private static void dfs(int sx, int sy, int score, int[][][] board) {
        score += board[sx][sy][0];
        max = Math.max(max, score);
        board[sx][sy][0] = 0;

        for(int f=1; f<17; f++) {
            int fx = -1, fy = -1;
            for(int x=0; x<4; x++) for(int y=0; y<4; y++) {
                if(board[x][y][0] == f) {
                    fx = x; fy = y;
                    break;
                }
            }
            if(fx == -1 && fy == -1) continue;
            int fd = board[fx][fy][1];

            for(int d=0; d<8; d++) {
                int nd = (fd+d)%8;
                int nx = fx+dx[nd], ny = fy+dy[nd];
                if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (nx == sx && ny == sy)) continue;
                
                board[fx][fy][1] = nd;
                
                int[] tmp = board[fx][fy];
                board[fx][fy] = board[nx][ny];
                board[nx][ny] = tmp;
                break;
            }
        }

        int sd = board[sx][sy][1];
        for(int i=1; i<5; i++) {
            int nx = sx+dx[sd]*i, ny = sy+dy[sd]*i;
            if(0 <= nx && nx < 4 && 0 <= ny && ny < 4 && board[nx][ny][0] > 0) {
                dfs(nx, ny, score, deepcopy(board));
            }
        }
    }

    private static int[][][] deepcopy(int[][][] board) {
        int[][][] tmp = new int[4][4][2];
        for(int i=0; i<4; i++) for(int j=0; j<4; j++) for(int k=0; k<2; k++) {
            tmp[i][j][k] = board[i][j][k];
        }
        return tmp;
    }

}
