package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj9376 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};

    private static int h, w;
    private static char[][] a;

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

        List<int[]> prisoner = new ArrayList<>();
        for(int i=0; i<h+2; i++) for(int j=0; j<w+2; j++) {
            if(a[i][j] == '$') prisoner.add(new int[]{i, j});
        }

        int[][] one = bfs(prisoner.get(0)[0], prisoner.get(0)[1]);
        int[][] two = bfs(prisoner.get(1)[0], prisoner.get(1)[1]);
        int[][] helper = bfs(0, 0);

        int ret = Integer.MAX_VALUE;

        for(int i=0; i<h+2; i++) for(int j=0; j<w+2; j++) {
            if(one[i][j] != -1 && two[i][j] != -1 && helper[i][j] != -1) {
                int tmp = one[i][j]+two[i][j]+helper[i][j];
                if(a[i][j] == '*') continue;
                if(a[i][j] == '#') tmp -= 2;
                ret = Math.min(ret, tmp);
            }
        }

        sb.append(ret).append('\n');
    }

    private static int[][] bfs(int y, int x) {
        int[][] visited = new int[h+2][w+2];
        for(int i=0; i<h+2; i++) Arrays.fill(visited[i], -1);
        visited[y][x] = 0;
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0], cx = cur[1];
            for(int i=0; i<4; i++) {
                int ny = cy+dy[i], nx = cx+dx[i];
                if(0 <= ny && ny < h+2 && 0 <= nx && nx < w+2 && visited[ny][nx] == -1) {
                    if(a[ny][nx] == '.' || a[ny][nx] == '$') {
                        visited[ny][nx]  = visited[cy][cx];
                        q.addFirst(new int[]{ny, nx});
                    }
                    else if(a[ny][nx] == '#') {
                        visited[ny][nx] = visited[cy][cx]+1;
                        q.addLast(new int[]{ny, nx});
                    }
                }        
            }
        }

        return visited;
    }

}
