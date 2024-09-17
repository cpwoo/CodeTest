package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj18405 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

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
        st.nextToken();

        int[][] board = new int[n][n];
        List<int[]> virus = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] != 0) {
                    virus.add(new int[]{board[i][j], i, j, 0});
                }
            }
        }

        Collections.sort(virus, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        Deque<int[]> q = new ArrayDeque<>();
        for(int[] v : virus) q.add(v);

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int v = cur[0], x = cur[1], y = cur[2], time = cur[3];

            if(time == S) break;

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = v;
                    q.add(new int[]{board[nx][ny], nx, ny, time+1});
                }
            }
        }

        bw.write(board[X-1][Y-1]+"");
    }

}
