package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj14442 {
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
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[N][M];
        for(int i=0; i<N; i++) {
            char[] inp = br.readLine().toCharArray();
            for(int j=0; j<M; j++) {
                board[i][j] = (inp[j] == '1');
            }
        }

        int[][][] visited = new int[N][M][K+1];
        for(int i=0; i<N; i++) for(int j=0; j<M; j++) {
            Arrays.fill(visited[i][j], -1);
        }
        visited[0][0][K] = 1;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, K});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], z = cur[2];

            if(x == N-1 && y == M-1) {
                bw.write(visited[x][y][z]+"");
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if(board[nx][ny] && z > 0 && visited[nx][ny][z-1] == -1) {
                        visited[nx][ny][z-1] = visited[x][y][z]+1;
                        q.add(new int[]{nx, ny, z-1});
                    }
                    if(!board[nx][ny] && visited[nx][ny][z] == -1) {
                        visited[nx][ny][z] = visited[x][y][z]+1;
                        q.add(new int[]{nx, ny, z});
                    }
                }
            }
        }

        bw.write("-1");
    }

}
