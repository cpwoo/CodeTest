package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16197 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m;
    private static char[][] board;
    private static Deque<int[]> q;

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
        List<int[]> tmp = new ArrayList<>();
        for(int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'o') tmp.add(new int[]{i, j});
            }
        }

        q = new ArrayDeque<>();
        q.add(new int[]{tmp.get(0)[0], tmp.get(0)[1], tmp.get(1)[0], tmp.get(1)[1], 0});

        bw.write(bfs()+"");
    }

    private static int bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x1 = cur[0], y1 = cur[1], x2 = cur[2], y2 = cur[3], cnt = cur[4];

            if(cnt >= 10) return -1;

            for(int i=0; i<4; i++) {
                int nx1 = x1+dx[i], ny1 = y1+dy[i], nx2 = x2+dx[i], ny2 = y2+dy[i];

                if(0 <= nx1 && nx1 < n && 0 <= ny1 && ny1 < m && 0 <= nx2 && nx2 < n && 0 <= ny2 && ny2 < m) {
                    if(board[nx1][ny1] == '#') {
                        nx1 = x1; ny1 = y1;
                    }
                    if(board[nx2][ny2] == '#') {
                        nx2 = x2; ny2 = y2;
                    }
                    q.add(new int[]{nx1, ny1, nx2, ny2, cnt+1});
                }
                else if(0 <= nx1 && nx1 < n && 0 <= ny1 && ny1 < m) return cnt+1;
                else if(0 <= nx2 && nx2 < n && 0 <= ny2 && ny2 < m) return cnt+1;
                else continue;
            }
        }

        return -1;
    }

}
