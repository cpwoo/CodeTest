package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj5427 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int w, h;
    private static Deque<int[]> q, fire;
    private static char board[][];
    private static boolean visited[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        q = new ArrayDeque<>(); fire = new ArrayDeque<>();

        board = new char[h][w];
        visited = new boolean[h][w];

        for(int i=0; i<h; i++) {
            board[i] = br.readLine().toCharArray();
            for(int j=0; j<w; j++) {
                if(board[i][j] == '@') {
                    visited[i][j] = true;
                    q.add(new int[]{i, j, 0});
                }
                else if(board[i][j] == '*') {
                    fire.add(new int[]{i, j, 0});
                }
            }
        }

        int ret = bfs();

        sb.append((ret != -1) ? ret : "IMPOSSIBLE").append('\n');
    }

    private static int bfs() {
        int cnt = 0;

        while(!q.isEmpty()) {
            cnt++;
            while(!fire.isEmpty() && fire.peek()[2] < cnt) {
                int[] cur = fire.poll();
                int x = cur[0], y = cur[1], time = cur[2];
                for(int i=0; i<4; i++) {
                    int nx = x+dx[i], ny = y+dy[i];
                    if(0 <= nx && nx < h && 0 <= ny && ny < w) {
                        if(board[nx][ny] == '.' || board[nx][ny] == '@') {
                            board[nx][ny] = '*';
                            fire.add(new int[]{nx, ny, time+1});
                        }
                    }
                }
            }
            while(!q.isEmpty() && q.peek()[2] < cnt) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1], time = cur[2];
                for(int i=0; i<4; i++) {
                    int nx = x+dx[i], ny = y+dy[i];
                    if(0 <= nx && nx < h && 0 <= ny && ny < w) {
                        if(board[nx][ny] == '.' && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny, time+1});
                        }
                    }
                    else return cnt;
                }
            }
        }
        return -1;
    }

}
