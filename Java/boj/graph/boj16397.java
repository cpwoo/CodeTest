package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16397 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, T, G;

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
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        bw.write(bfs());
    }

    private static String bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N, 0});

        boolean[] visited = new boolean[100000];
        visited[N] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], cost = cur[1];

            if(cost > T) return "ANG";

            if(x == G) return String.valueOf(cost);

            if(x+1 < 100000 && !visited[x+1]) {
                q.add(new int[]{x+1, cost+1});
                visited[x+1] = true;
            }
            if(0 < 2*x && 2*x < 100000) {
                int tmp = 1;
                while(10*tmp <= 2*x) {
                    tmp *= 10;
                }
                
                q.add(new int[]{2*x-tmp, cost+1});
                visited[2*x-tmp] = true;
            }

        }

        return "ANG";
    }

}
