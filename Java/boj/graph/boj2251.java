package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2251 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int a, b, c;
    private static Deque<int[]> q;
    private static boolean visited[][];
    private static List<Integer> ret;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        visited = new boolean[a+1][b+1];
        visited[0][0] = true;

        ret = new ArrayList<>();
        bfs();

        Collections.sort(ret);

        sb = new StringBuilder();
        for(int r : ret) sb.append(r).append(' ');

        bw.write(sb.toString());
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int z = c-x-y;

            if(x == 0) ret.add(z);

            int water = Math.min(x, b-y);
            pour(x-water, y+water);

            water = Math.min(x, c-z);
            pour(x-water, y);

            water = Math.min(y, a-x);
            pour(x+water, y-water);

            water = Math.min(y, c-z);
            pour(x, y-water);

            water = Math.min(z, a-x);
            pour(x+water, y);

            water = Math.min(z, b-y);
            pour(x, y+water);
        }
    }

    private static void pour(int x, int y) {
        if(!visited[x][y]) {
            visited[x][y] = true;
            q.add(new int[]{x, y});
        }
    }

}
