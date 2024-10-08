package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj21609 {
    static class Group implements Comparable<Group> {
        int x, y, blockCnt, rainbowCnt;

        Group(int x, int y, int blockCnt, int rainbowCnt) {
            this.x = x;
            this.y = y;
            this.blockCnt = blockCnt;
            this.rainbowCnt = rainbowCnt;
        }

        @Override
        public int compareTo(Group o) {
            if(this.blockCnt != o.blockCnt) return o.blockCnt-this.blockCnt;
            else if(this.rainbowCnt != o.rainbowCnt) return o.rainbowCnt-this.rainbowCnt;
            else if(this.x != o.x) return o.x-this.x;
            return o.y-this.y;
        }
    }

    static class Info {
        int x, y;
        Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int N, score, a[][];
    private static boolean[][] visited;
    private static List<Group> blocks;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st.nextToken();

        a = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        score = 0;

        while(true) {
            if(!findBlockGroup()) break;
            gravity();
            rotate();
            gravity();
        }

        bw.write(score+"");
    }

    private static boolean findBlockGroup() {
        visited = new boolean[N][N];
        blocks = new ArrayList<>();

        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            if(!visited[i][j] && a[i][j] > 0) {
                bfs(i, j, true);
            }
        }

        if(blocks.isEmpty()) return false;

        visited = new boolean[N][N];
        Collections.sort(blocks);
        bfs(blocks.get(0).x, blocks.get(0).y, false);
        
        remove();

        return true;
    }

    private static void bfs(int x, int y, boolean flag) {
        int blockCnt = 1, rainbowCnt = 0;
        visited[x][y] = true;

        Deque<Info> q = new ArrayDeque<>();
        q.add(new Info(x, y));

        while(!q.isEmpty()) {
            Info cur = q.poll();

            for(int d=0; d<4; d++) {
                int nx = cur.x+dx[d], ny = cur.y+dy[d];
                if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    if(a[nx][ny] == 0 || a[nx][ny] == a[x][y]) {
                        visited[nx][ny] = true;
                        blockCnt++;
                        if(a[nx][ny] == 0) rainbowCnt++;
                        q.add(new Info(nx, ny));
                    }
                }
            }
        }

        if(blockCnt >= 2) blocks.add(new Group(x, y, blockCnt, rainbowCnt));

        if(flag) {
            for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
                if(a[i][j] == 0) visited[i][j] = false;
            }
        }
    }

    private static void remove() {
        int cnt = 0;
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            if(visited[i][j]) {
                cnt++;
                a[i][j] = -2;
            }
        }

        score += cnt*cnt;
    }

    private static void gravity() {
        for(int x=N-1; x>=0; x--) for(int y=0; y<N; y++) {
            if(a[x][y] >= 0) {
                int nx = x;
                while(true) {
                    nx++;
                    if(nx >= N || a[nx][y] != -2) break;
                }
                nx--;
                if(nx != x) {
                    a[nx][y] = a[x][y];
                    a[x][y] = -2;
                }
            }
        }
    }

    private static void rotate() {
        int[][] tmp = new int[N][N];

        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            tmp[(N-1)-j][i] = a[i][j];
        }

        a = tmp;
    }
}
