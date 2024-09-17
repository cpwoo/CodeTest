package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj17141 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, lab[][], choice[][], ret;
    private static List<int[]> virus;

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

        lab = new int[n][n];
        virus = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        choice = new int[m][2];

        ret = Integer.MAX_VALUE;
        comb(0, 0);

        bw.write((ret != Integer.MAX_VALUE) ? ret+"" : "-1");
    }

    private static void comb(int start, int cnt) {
        if(cnt == m) {
            ret = Math.min(ret, bfs());
            return;
        }

        for(int i=start; i<virus.size(); i++) {
            choice[cnt][0] = virus.get(i)[0];
            choice[cnt][1] = virus.get(i)[1];
            comb(i+1, cnt+1);
        }
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();

        int[][] visited = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(visited[i], -1);

        for(int i=0; i<m; i++) {
            q.add(new int[]{choice[i][0], choice[i][1]});
            visited[choice[i][0]][choice[i][1]] = 0;
        }

        int max = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == -1 && lab[nx][ny] != 1) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[x][y]+1;
                    max = Math.max(max, visited[x][y]+1);
                }
            }
        }

        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(visited[i][j] == -1 && lab[i][j] != 1) {
                return Integer.MAX_VALUE;
            }
        }

        return max;
    }

}
