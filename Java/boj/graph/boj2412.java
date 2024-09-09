package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2412 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, T;
    private static Set<Integer> visited[];

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
        T = Integer.parseInt(st.nextToken());

        visited = new HashSet[1_000_001];
        for(int i=0; i<1_000_001; i++) visited[i] = new HashSet<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited[x].add(y);
        }

        bw.write(bfs()+"");
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], cnt = cur[2];

            if(y == T) return cnt;

            for(int nx=x-2; nx<=x+2; nx++) for(int ny=y-2; ny<=y+2; ny++) {
                if(nx < 0 || ny < 0) continue;
                if(visited[nx].contains(ny)) {
                    visited[nx].remove(ny);
                    q.add(new int[]{nx, ny, cnt+1});
                }
            }
        }

        return -1;
    }

}
