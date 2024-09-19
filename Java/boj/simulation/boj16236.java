package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj16236 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};

    private static int N, graph[][];
    private static Stack<int[]> shark;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = 0, y = 0, sz = 2;

        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            if(graph[i][j] == 9) {
                x = i; y = j;
            }
        }

        int cnt = 0, ret = 0;

        while(true) {
            shark = new Stack<>();
            game(x, y, sz);

            if(shark.isEmpty()) break;

            int[] cur = shark.pop();
            int nx = cur[0], ny = cur[1], distance = cur[2];

            ret += distance;
            graph[x][y] = graph[nx][ny] = 0;

            x = nx; y = ny;

            cnt++;
            if(cnt == sz) {
                sz++;
                cnt = 0;
            }
        }

        bw.write(ret+"");
    }

    private static void game(int x, int y, int sz) {
        int[][] dist = new int[N][N];

        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int tx = cur[0], ty = cur[1];
            for(int i=0; i<4; i++) {
                int nx = tx+dx[i], ny = ty+dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    if(graph[nx][ny] <= sz) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[tx][ty]+1;
                        
                        if(graph[nx][ny] < sz && graph[nx][ny] != 0) {
                            shark.add(new int[]{nx, ny, dist[nx][ny]});
                        }
                    }
                }
            }
        }

        Collections.sort(shark, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] != o2[2]) return o2[2]-o1[2];
                else if(o1[0] != o2[0]) return o2[0]-o1[0];
                return o2[1]-o1[1];
            }
        });
    }

}
