package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj4991 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int[] dr = {1,-1,0,0}, dc = {0,0,1,-1};

    private static int w, h, n, dist[][], dp[][];
    private static char board[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        board = new char[h][w];
        for(int i=0; i<h; i++) board[i] = br.readLine().toCharArray();

        List<int[]> target = new ArrayList<>();
        int cr = 0, cc = 0;
        for(int r=0; r<h; r++) for(int c=0; c<w; c++) {
            if(board[r][c] == 'o') {
                cr = r; cc = c;
                target.add(0, new int[]{r, c});
            }
            else if(board[r][c] == '*') target.add(new int[]{r, c});
        }

        n = target.size();
        int[][] visited = bfs(cr, cc);

        for(int i=0; i<n; i++) {
            int tmp = visited[target.get(i)[0]][target.get(i)[1]];
            if(tmp == 0) {
                sb.append("-1\n");
                return;
            }
        }
        
        dist = new int[n][n];
        for(int i=0; i<n-1; i++) {
            visited = bfs(target.get(i)[0], target.get(i)[1]);
            for(int j=i+1; j<n; j++) {
                dist[i][j] = dist[j][i] = visited[target.get(j)[0]][target.get(j)[1]]-1;
            }
        }

        dp = new int[n][(1<<n)];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        sb.append(tsp(0, 1)).append('\n');
    }

    private static int[][] bfs(int i, int j) {
        int[][] visited = new int[h][w];
        visited[i][j] = 1;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for(int d=0; d<4; d++) {
                int nr = r+dr[d], nc = c+dc[d];
                if(0 <= nr && nr < h && 0 <= nc && nc < w && visited[nr][nc] == 0) {
                    if(board[nr][nc] != 'x') {
                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = visited[r][c]+1;
                    }
                }
            }
        }

        return visited;
    }

    private static int tsp(int cur, int r) {
        if(dp[cur][r] != -1) return dp[cur][r];

        if(r == (1<<n)-1) return 0;

        dp[cur][r] = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if((r&(1<<i)) > 0) continue;
            dp[cur][r] = Math.min(dp[cur][r], dist[cur][i]+tsp(i, r|(1<<i)));
        }

        return dp[cur][r];
    }

}
