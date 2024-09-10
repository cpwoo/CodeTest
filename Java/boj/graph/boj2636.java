package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2636 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, cheese[][];
    private static List<Integer> ret;

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

        cheese = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) cheese[i][j] = Integer.parseInt(st.nextToken());
        }

        ret = new ArrayList<>();

        int time = 0;
        while(true) {
            time++;
            if(bfs() == 0) break;
        }

        bw.write(time-1+"\n"+ret.get(time-2)+"");
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        int cnt = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    if(cheese[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                    else if(cheese[nx][ny] == 1) {
                        cheese[nx][ny] = 0;
                        visited[nx][ny] = true;
                        cnt++;
                    }
                }
            }
        }

        ret.add(cnt);

        return cnt;
    }

}
