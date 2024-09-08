package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1938 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, ret, start[], end[];
    private static char map[][];
    private static boolean v[][][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        ret = Integer.MAX_VALUE;
        map = new char[n][n];
        v = new boolean[n][n][2];

        List<int[]> s = new ArrayList<>(), e = new ArrayList<>();
        start = new int[3]; end = new int[3];

        for(int i=0; i<n; i++) {
            char[] inp = br.readLine().toCharArray();
            for(int j=0; j<n; j++) {
                map[i][j] = inp[j];
                if(map[i][j] == 'B') s.add(new int[]{i, j});
                else if(map[i][j] == 'E') e.add(new int[]{i, j});
            }
        }

        start[0] = s.get(1)[0]; start[1] = s.get(1)[1];
        start[2] = (s.get(0)[0] == s.get(1)[0]) ? 1 : 0;

        end[0] = e.get(1)[0]; end[1] = e.get(1)[1];
        end[2] = (e.get(0)[0] == e.get(1)[0]) ? 1 : 0;

        bfs();

        bw.write((ret != Integer.MAX_VALUE) ? ret+"" : "0");
    }

    private static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        v[start[0]][start[1]][start[2]] = true;
        q.add(new int[]{start[0], start[1], start[2], 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == end[0] && cur[1] == end[1] && cur[2] == end[2]) {
                ret = cur[3];
                return;
            }
            
            for(int i=0; i<4; i++) {
                int nx = cur[0]+dx[i], ny = cur[1]+dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n || v[nx][ny][cur[2]] || map[nx][ny] == '1') continue;

                if(cur[2] == 1) {
                    if(ny-1 < 0 || map[nx][ny-1] == '1') continue;
                    if(ny+1 >= n || map[nx][ny+1] == '1') continue;
                }
                else {
                    if(nx-1 < 0 || map[nx-1][ny] == '1') continue;
                    if(nx+1 >= n || map[nx+1][ny] == '1') continue;
                }

                if(map[nx][ny] != '1') {
                    v[nx][ny][cur[2]] = true;
                    q.add(new int[]{nx, ny, cur[2], cur[3]+1});
                }
            }

            if(!v[cur[0]][cur[1]][(cur[2]+1)%2]) {
                boolean chk = true;
                for(int i=cur[0]-1; i<=cur[0]+1; i++) {
                    if(!chk) break;
                    for(int j=cur[1]-1; j<=cur[1]+1; j++) {
                        if(i < 0 || i >= n || j < 0 || j >= n || map[i][j] == '1') {
                            chk = false;
                            break;
                        }
                    }
                }
                if(chk) {
                    v[cur[0]][cur[1]][(cur[2]+1)%2] = true;
                    q.add(new int[]{cur[0], cur[1], (cur[2]+1)%2, cur[3]+1});
                }
            }
        }
    }

}
