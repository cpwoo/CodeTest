package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16946 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, zeros[][], group;
    private static boolean board[][], visited[][];
    private static Map<Integer, Integer> info;

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

        board = new boolean[n][m];
        for(int i=0; i<n; i++) {
            char[] inp = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                board[i][j] = (inp[j] == '1');
            }
        }

        visited = new boolean[n][m];
        zeros = new int[n][m];

        group = 1;
        info = new HashMap<>();

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(!board[i][j] && !visited[i][j]) {
                int cnt = bfs(i, j);
                info.put(group, cnt);
                group++;
            }
        }

        int[][] ret = new int[n][m];

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j]) ret[i][j] = moveCnt(i, j);
        }

        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(ret[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

    private static int bfs(int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});

        visited[i][j] = true;
        int cnt = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            zeros[x][y] = group;

            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && !board[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static int moveCnt(int x, int y) {
        Set<Integer> data = new HashSet<>();

        for(int i=0; i<4; i++) {
            int nx = x+dx[i], ny = y+dy[i];
            if(0 <= nx && nx < n && 0 <= ny && ny < m && zeros[nx][ny] != 0) {
                data.add(zeros[nx][ny]);
            }
        }

        int cnt = 1;
        for(int d : data) {
            cnt += info.getOrDefault(d, 0);
            cnt %= 10;
        }

        return cnt;
    }

}
