package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj9328 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

    private static int h, w;
    private static char[][] a;
    private static boolean[] door;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        a = new char[h+2][w+2];

        for(int i=0; i<h+2; i++) {
            a[i][0] = a[i][w+1] = '.';
        }

        for(int j=0; j<w+2; j++) {
            a[0][j] = a[h+1][j] = '.';
        }

        for(int i=1; i<h+1; i++) {
            String inp = br.readLine();
            for(int j=1; j<w+1; j++) {
                a[i][j] = inp.charAt(j-1);
            }
        }

        String key = br.readLine();
        door = new boolean[26];
        for(char k : key.toCharArray()) {
            if(k != '0') door[k-'a'] = true;
        }

        for(int i=1; i<h+1; i++) for(int j=1; j<w+1; j++) {
            if('A' <= a[i][j] && a[i][j] <= 'Z' && door[a[i][j]-'A']) {
                a[i][j] = '.';
            }
        }

        sb.append(bfs(0, 0)).append('\n');
    }

    private static int bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        boolean[][] c = new boolean[h+2][w+2];
        c[x][y] = true;

        int cnt = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            for(int i=0; i<4; i++) {
                int nx = cx+dx[i], ny = cy+dy[i];
                if(0 <= nx && nx < h+2 && 0 <= ny && ny < w+2 && !c[nx][ny]) {
                    if(a[nx][ny] == '.') {
                        c[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                    else if('a' <= a[nx][ny] && a[nx][ny] <= 'z') {
                        door[a[nx][ny]-'a'] = true;
                        q.clear();
                        c = new boolean[h+2][w+2];
                        a[nx][ny] = '.';
                        q.add(new int[]{nx, ny});
                    }
                    else if('A' <= a[nx][ny] && a[nx][ny] <= 'Z') {
                        if(door[a[nx][ny]-'A']) {
                            c[nx][ny] = true;
                            a[nx][ny] = '.';
                            q.add(new int[]{nx, ny});
                        }
                    }
                    else if(a[nx][ny] == '$') {
                        c[nx][ny] = true;
                        cnt++;
                        a[nx][ny] = '.';
                        q.add(new int[]{nx, ny});
                    }
                }        
            }
        }

        return cnt;
    }

}
