package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj17143 {
    static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    
    private static final int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};

    private static int r, c, m;
    private static Shark[][] map;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new Shark[r][c];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(d == 1) d = 0;
            else if(d == 4) d = 1;

            map[x-1][y-1] = new Shark(x-1, y-1, s, d, z);
        }

        int eatCnt = 0;

        for(int col=0; col<c; col++) {
            for(int row=0; row<r; row++) {
                if(map[row][col] != null) {
                    eatCnt += map[row][col].z;
                    map[row][col] = null;
                    break;
                }
            }

            Deque<Shark> q = new ArrayDeque<>();
            for(int i=0; i<r; i++) for(int j=0; j<c; j++) {
                if(map[i][j] != null) {
                    q.add(new Shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
                }
            }

            map = new Shark[r][c];

            while(!q.isEmpty()) {
                Shark shark = q.poll();
                int speed = shark.s;
                if(shark.d == 0 || shark.d == 2) speed %= (r-1)*2;
                else if(shark.d == 1 || shark.d == 3) speed %= (c-1)*2;

                for(int s=0; s<speed; s++) {
                    int nr = shark.r+dx[shark.d], nc = shark.c+dy[shark.d];
                    if(nr < 0 || nr >= r || nc < 0 || nc >= c) {
                        shark.r -= dx[shark.d];
                        shark.c -= dy[shark.d];
                        shark.d = (shark.d+2)%4;
                        continue;
                    }
                    shark.r = nr; shark.c = nc;
                }

                if(map[shark.r][shark.c] != null) {
                    if(map[shark.r][shark.c].z < shark.z) {
                        map[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.s, shark.d, shark.z);
                    }
                }
                else map[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.s, shark.d, shark.z);
            }
        }

        bw.write(eatCnt+"");
    }

}
