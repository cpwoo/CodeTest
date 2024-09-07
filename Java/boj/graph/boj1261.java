package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1261 {
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
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for(int i=0; i<N; i++) {
            char[] inp = br.readLine().toCharArray();
            for(int j=0; j<M; j++) board[i][j] = inp[j]-'0';
        }

        int[][] d = new int[N][M];
        for(int i=0; i<N; i++) Arrays.fill(d[i], -1);
        d[0][0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1];
            for(int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];
                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if(d[nx][ny] == -1) {
                        if(board[nx][ny] == 0) {
                            d[nx][ny] = d[x][y];
                            q.addFirst(new int[]{nx, ny});
                        }
                        else {
                            d[nx][ny] = d[x][y]+1;
                            q.addLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        bw.write(d[N-1][M-1]+"");
    }

}
