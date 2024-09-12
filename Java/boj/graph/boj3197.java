package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj3197 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

    private static int m, n, x1, y1, x2, y2;
    private static char a[][];
    private static boolean c[][], wc[][];

    private static Deque<int[]> q, qTmp, wq, wqTmp;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        a = new char[m][n];
        List<int[]> swan = new ArrayList<>();
        wq = new ArrayDeque<>();
        wc = new boolean[m][n];

        for(int i=0; i<m; i++) {
            a[i] = br.readLine().toCharArray();
            for(int j=0; j<n; j++) {
                if(a[i][j] == 'L') {
                    swan.add(new int[]{i, j});
                    wq.add(new int[]{i, j});
                }
                else if(a[i][j] == '.') {
                    wc[i][j] = true;
                    wq.add(new int[]{i, j});
                }
            }
        }

        x1 = swan.get(0)[0]; y1 = swan.get(0)[1];
        x2 = swan.get(1)[0]; y2 = swan.get(1)[1];

        q = new ArrayDeque<>();
        q.add(new int[]{x1, y1});

        qTmp = new ArrayDeque<>(); wqTmp = new ArrayDeque<>();
        
        c = new boolean[m][n];
        a[x1][y1] = '.'; a[x2][y2] = '.'; c[x1][y1] = true;
        
        int cnt = 0;
        while(true) {
            melt();
            if(bfs()) {
                bw.write(cnt+"");
                return;
            }
            q = qTmp; wq = wqTmp;
            qTmp = new ArrayDeque<>();
            wqTmp = new ArrayDeque<>();
            cnt++;
        }

    }

    private static void melt() {
        while(!wq.isEmpty()) {
            int[] cur = wq.poll();
            int x = cur[0], y = cur[1];
            if(a[x][y] == 'X') a[x][y] = '.';

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if(!wc[nx][ny]) {
                        if(a[nx][ny] == 'X') wqTmp.add(new int[]{nx, ny});
                        else wq.add(new int[]{nx, ny});
                        wc[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static boolean bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(x == x2 && y == y2) return true;

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if(!c[nx][ny]) {
                        if(a[nx][ny] == '.') q.add(new int[]{nx, ny});
                        else qTmp.add(new int[]{nx, ny});
                        c[nx][ny] = true;
                    }
                }
            }
        }
        return false;
    }

}
