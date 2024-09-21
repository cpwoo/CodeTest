package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj17822 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};

    private static int n, m, graph[][];
    private static boolean visited[][];
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    sum += graph[i][j];
                }
                if((i+1)%x == 0) rotate(i, d, k);
            }
            if(sum == 0) break;
            else {
                visited = new boolean[n][m];
                int cnt = 0;
                for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
                    if(!visited[i][j] && graph[i][j] != 0) {
                        cnt += bfs(i, j);
                    }
                }
                if(cnt == 0) changeAvg();
            }
        }

        int ret = 0;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            ret += graph[i][j];
        }

        bw.write(ret+"");
    }

    private static void rotate(int x, int d, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int j=0; j<m; j++) q.add(graph[x][j]);

        if(d == 0) for(int j=0; j<k; j++) q.addFirst(q.pollLast());
        else for(int j=0; j<k; j++) q.addLast(q.pollFirst());

        for(int j=0; j<m; j++) graph[x][j] = q.pollFirst();
    }

    private static int bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        visited[x][y] = true;
        int value = graph[x][y];
        graph[x][y] = 0;

        int cnt = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0]; y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(ny < 0 || ny >= m) {
                    if(y == 0) ny = m-1;
                    else if(y == m-1) ny = 0;
                }
                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(!visited[nx][ny]) {
                        if(graph[nx][ny] == value) {
                            cnt++;
                            graph[nx][ny] = 0;
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        if(cnt == 0) graph[x][y] = value;

        return cnt;
    }

    private static void changeAvg() {
        int avgCnt = 0, allSum = 0;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(graph[i][j] != 0) {
                avgCnt++;
                allSum += graph[i][j];
            }
        }

        if(avgCnt == 0) return;

        double avg = (double) allSum/avgCnt;

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(graph[i][j] != 0) {
                if(graph[i][j] > avg) graph[i][j]--;
                else if(graph[i][j] < avg) graph[i][j]++;
            }
        }
    }

}
