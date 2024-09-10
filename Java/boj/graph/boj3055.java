package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj3055 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int N, M, visited[][], Dx, Dy;
    private static char graph[][];
    private static Deque<int[]> q;

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
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        for(int i=0; i<N; i++) graph[i] = br.readLine().toCharArray();

        visited = new int[N][M];

        q = new ArrayDeque<>();

        for(int i=0; i<N; i++) for(int j=0; j<M; j++) {
            if(graph[i][j] == 'S') q.add(new int[]{i, j});
            else if(graph[i][j] == 'D') {
                Dx = i; Dy = j;
            }
        }

        for(int i=0; i<N; i++) for(int j=0; j<M; j++) {
            if(graph[i][j] == '*') q.add(new int[]{i, j});
        }

        bw.write(bfs());
    }

    private static String bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if(graph[Dx][Dy] == 'S') return String.valueOf(visited[Dx][Dy]);

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if((graph[nx][ny] == '.' || graph[nx][ny] == 'D') && graph[x][y] == 'S') {
                        graph[nx][ny] = 'S';
                        visited[nx][ny] = visited[x][y]+1;
                        q.add(new int[]{nx, ny});
                    }
                    else if((graph[nx][ny] == '.' || graph[nx][ny] == 'S') && graph[x][y] == '*') {
                        graph[nx][ny] = '*';
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return "KAKTUS";
    }

}
