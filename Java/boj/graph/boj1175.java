package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1175 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    private static final int INF = Integer.MAX_VALUE;

    private static int n, m, ret;
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
            board[i] = br.readLine().toCharArray();
        }
    
        int sR = -1, sC = -1;

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] == 'S') {
                sR = i; sC = j;
                break;
            }
        }

        board[sR][sC] = '.';

        ret = INF;

        for(int k=0; k<4; k++) find(0, sR, sC, k, 0);

        bw.write((ret != INF) ? ret+"" : "-1");
    }

    private static void find(int d, int sR, int sC, int to, int cnt) {
        if(ret <= d) return;

        if(cnt == 2) {
            ret = Math.min(ret, d);
            return;
        }

        int[][][] visited = new int[n][m][4];
        visited[sR][sC][to] = d;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sR, sC, to});

        List<int[]> cs = new ArrayList<>();

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], t = cur[2];
            
            if(board[r][c] == 'C') cs.add(new int[]{r, c, t});
            
            for(int k=0; k<4; k++) {
                if(k == t) continue;
                int nr = r+dr[k], nc = c+dc[k];
                if(0 <= nr && nr < n && 0 <= nc && nc < m && board[nr][nc] != '#' && visited[nr][nc][k] == 0) {
                    visited[nr][nc][k] = visited[r][c][t]+1;
                    q.add(new int[]{nr, nc, k});
                }
            }
        }

        for(int[] c : cs) {
            int nr = c[0], nc = c[1], nt = c[2];
            board[nr][nc] = '.';
            find(visited[nr][nc][nt], nr, nc, nt, cnt+1);
            board[nr][nc] = 'C';
        }
    }

}
