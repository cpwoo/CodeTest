package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16988 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, board[][];
    private static boolean visited[][];

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

        board = new int[n][m];
        List<int[]> cand = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) {
                    cand.add(new int[]{i, j});
                }
            }
        }

        int L = cand.size();
        int ret = 0;
        for(int i=0; i<L-1; i++) for(int j=i+1; j<L; j++) {
            int[] a = cand.get(i), b = cand.get(j);
            board[a[0]][a[1]] = board[b[0]][b[1]] = 1;
            ret = Math.max(ret, cnt(a, b));
            board[a[0]][a[1]] = board[b[0]][b[1]] = 0;
        }

        bw.write(ret+"");
    }

    private static int cnt(int[] a, int[] b) {
        visited = new boolean[n][m];

        int tmp = 0;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] == 2 && !visited[i][j]) {
                tmp += bfs(i, j);
            }
        }

        return tmp;
    }

    private static int bfs(int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});

        visited[i][j] = true;

        boolean flag = true;
        int tmp = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    if(board[nx][ny] == 0) flag = false;
                    else if(board[nx][ny] == 2) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        tmp++;
                    }
                }
            }
        }

        return (flag) ? tmp : 0;
    }

}
