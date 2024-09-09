package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2151 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) board[i] = br.readLine().toCharArray();

        List<int[]> door = new ArrayList<>();
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(board[i][j] == '#') door.add(new int[]{i, j});
        }

        int sx = door.get(0)[0], sy = door.get(0)[1], ex = door.get(1)[0], ey = door.get(1)[1];

        Deque<int[]> q = new ArrayDeque<>();
        for(int d=0; d<4; d++) q.add(new int[]{sx, sy, d});

        int[][][] visited = new int[n][n][4];
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            Arrays.fill(visited[i][j], -1);
        }

        Arrays.fill(visited[sx][sy], 0);

        while(!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1], d = cur[2];
            
            if(x == ex && y == ey) {
                bw.write(visited[ex][ey][d]+"");
                break;
            }
            
            int nx = x+dx[d], ny = y+dy[d];
            if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                if(board[nx][ny] != '*') {
                    if(visited[nx][ny][d] == -1 || visited[nx][ny][d] > visited[x][y][d]) {
                        visited[nx][ny][d] = visited[x][y][d];
                        q.addFirst(new int[]{nx, ny, d});
                    }
                    if(board[nx][ny] == '!') {
                        if(d < 2) {
                            for(int nd=2; nd<=3; nd++) {
                                if(visited[nx][ny][nd] == -1 || visited[nx][ny][nd] > visited[x][y][d]+1) {
                                    visited[nx][ny][nd] = visited[x][y][d]+1;
                                    q.addLast(new int[]{nx, ny, nd});
                                }
                            }
                        }
                        else {
                            for(int nd=0; nd<=1; nd++) {
                                if(visited[nx][ny][nd] == -1 || visited[nx][ny][nd] > visited[x][y][d]+1) {
                                    visited[nx][ny][nd] = visited[x][y][d]+1;
                                    q.addLast(new int[]{nx, ny, nd});
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
