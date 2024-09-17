package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj22944 {
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
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][N];
        int sx = -1, sy = -1;
        for(int x=0; x<N; x++) {
            board[x] = br.readLine().toCharArray();
            for(int y=0; y<N; y++) {
                if(board[x][y] == 'S') {
                    sx = x; sy = y;
                }
            }
        }

        int[][] visited = new int[N][N];
        visited[sx][sy] = H;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, H, 0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], h = cur[2], d = cur[3], cnt = cur[4];

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if(board[nx][ny] == 'E') {
                        bw.write(cnt+1+"");
                        return;
                    }
                    int nh = h, nd = d;

                    if(board[nx][ny] == 'U') nd = D;

                    if(nd == 0) nh -= 1;
                    else nd -= 1;

                    if(nh == 0) continue;

                    if(visited[nx][ny] < nh) {
                        visited[nx][ny] = nh;
                        q.add(new int[]{nx, ny, nh, nd, cnt+1});
                    }
                }
            }
        }

        bw.write("-1");
    }

}
