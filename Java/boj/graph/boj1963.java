package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1963 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static boolean chk[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        chk = new boolean[10000];
        Arrays.fill(chk, true);
        for(int i=2; i<100; i++) {
            if(chk[i]) {
                for(int j=i*i; j<10000; j+=i) chk[j] = false;
            }
        }

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ret = bfs(start, end);
            sb.append((ret != -1) ? ret : "Impossible").append('\n');
        }

        bw.write(sb.toString());
    }

    private static int bfs(int start, int end) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});

        boolean[] visited = new boolean[10000];
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0], cnt = cur[1];
            if(now == end) return cnt;

            String strNow = String.valueOf(now);
            for(int i=0; i<4; i++) for(int j=0; j<10; j++) {
                Integer tmp = Integer.parseInt(strNow.substring(0, i)+String.valueOf(j)+strNow.substring(i+1));

                if(!visited[tmp] && chk[tmp] && tmp >= 1000) {
                    visited[tmp] = true;
                    q.add(new int[]{tmp, cnt+1});
                }
            }
        }

        return -1;
    }

}
