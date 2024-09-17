package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj22352 {
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
        int m = Integer.parseInt(st.nextToken());
        
        int[][] before = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                before[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] after = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                after[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        boolean flag = true;

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(before[i][j] != after[i][j]) {
                if(cnt >= 1) flag = false;
                else {
                    cnt++;

                    int bef = before[i][j], aft = after[i][j];
                    before[i][j] = aft;

                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;

                    Deque<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        for(int d=0; d<4; d++) {
                            int nx = x+dx[d], ny = y+dy[d];
                            if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                                if(before[nx][ny] == bef && !visited[nx][ny]) {
                                    before[nx][ny] = aft;
                                    visited[nx][ny] = true;
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(before[i][j] != after[i][j]) {
                flag = false;
                break;
            }
        }
        
        bw.write(flag ? "YES" : "NO");
    }

}
