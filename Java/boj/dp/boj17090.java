package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj17090 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,1,0,-1};

    private static int n, m, v[][];
    private static char board[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for(int i=0; i<n; i++) {
            char[] inp = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                board[i][j] = inp[j];
            }
        }

        v = new int[n][m];

        int ret = 0;

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(dfs(i, j) == 1) ret++;
        }
        
        bw.write(ret+"");
    }

    private static int dfs(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m) return 1;

        if(v[x][y] != 0) return v[x][y];

        v[x][y] = -1;
        
        return v[x][y] = dfs(x+dx[d(board[x][y])], y+dy[d(board[x][y])]);
    }

    private static int d(char x) {
        switch(x) {
            case('U'): return 0;
            case('R'): return 1;
            case('D'): return 2;
            case('L'): return 3;
        }
        return -1;
    }

}
