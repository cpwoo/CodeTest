package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj18430 {
    private static int n, m, answer;
    private static int[][] board, shape;
    private static boolean[][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inp = br.readLine().split(" ");
        n = Integer.parseInt(inp[0]);
        m = Integer.parseInt(inp[1]);

        board = new int[n][m];
        for(int i=0; i<n; i++) {
            inp = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(inp[j]);
            }
        }

        shape = new int[][]{{0,-1,1,0}, {-1,0,0,-1}, {-1,0,0,1}, {0,1,1,0}};

        v = new boolean[n][m];
        answer = 0;

        dfs(0, 0, 0);

        bw.write(answer+"");

        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y, int total) {
        if(y == m) {
            x++;
            y = 0;
        }

        if(x == n) {
            answer = Math.max(answer, total);
            return;
        }

        if(!v[x][y]) {
            for(int k=0; k<4; k++) {
                int px = x+shape[k][0];
                int py = y+shape[k][1];
                int qx = x+shape[k][2];
                int qy = y+shape[k][3];
                if(chk(px, py) && chk(qx, qy) && !v[px][py] && !v[qx][qy]) {
                    v[px][py] = v[qx][qy] = v[x][y] = true;
                    dfs(x, y+1, total + board[x][y]*2 + board[px][py] + board[qx][qy]);
                    v[px][py] = v[qx][qy] = v[x][y] = false;
                }
            }
        }

        dfs(x, y+1, total);
    }

    private static boolean chk(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

}
