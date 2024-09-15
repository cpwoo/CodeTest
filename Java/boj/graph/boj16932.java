package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16932 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dy = {0,1,0,-1}, dx = {1,0,-1,0};

    private static int n, m, grid[][], num, group[];
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

        grid = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) grid[i][j] = Integer.parseInt(st.nextToken());
        }

        List<int[]> zeros = new ArrayList<>(), ones = new ArrayList<>();
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(grid[i][j] == 0) zeros.add(new int[]{i, j});
            if(grid[i][j] == 1) ones.add(new int[]{i, j});
        }

        visited = new boolean[n][m];

        num = 1;
        group = new int[n*m+1];

        for(int[] pos : ones) {
            if(!visited[pos[0]][pos[1]]) {
                findGroup(pos[0], pos[1]);
                num++;
            }
        }

        int ret = 0;
        Set<Integer> near = new HashSet<>();

        for(int[] pos : zeros) {
            int tmp = 1;
            near.clear();
            for(int i=0; i<4; i++) {
                int ny = pos[0]+dy[i], nx = pos[1]+dx[i];
                if(0 <= ny && ny < n && 0 <= nx && nx < m) {
                    if(!near.contains(grid[ny][nx])) {
                        near.add(grid[ny][nx]);
                        tmp += group[grid[ny][nx]];
                    }
                }
            }
            ret = Math.max(ret, tmp);
        }

        bw.write(ret+"");
    }

    private static void findGroup(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});

        visited[y][x] = true;

        List<int[]> path = new ArrayList<>();
        path.add(new int[]{y, x});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            y = cur[0]; x = cur[1];
            for(int i=0; i<4; i++) {
                int ny = y+dy[i], nx = x+dx[i];
                if(0 <= ny && ny < n && 0 <= nx && nx < m && grid[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    path.add(new int[]{ny, nx});
                    q.add(new int[]{ny, nx});
                }
            }
        }

        for(int[] p : path) grid[p[0]][p[1]] = num;
        
        group[num] = path.size();
    }

}
