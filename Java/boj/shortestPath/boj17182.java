package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj17182 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, graph[][], ret;
    private static boolean v[];

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
        int K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int k=0; k<N; k++) for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
        }

        v = new boolean[N];
        v[K] = true;

        ret = Integer.MAX_VALUE;

        search(K, 1, 0);

        bw.write(ret+"");
    }

    private static void search(int cur, int cnt, int cost) {
        if(cnt == N) {
            ret = Math.min(ret, cost);
            return;
        }

        for(int nxt=0; nxt<N; nxt++) {
            if(!v[nxt]) {
                v[nxt] = true;
                search(nxt, cnt+1, cost+graph[cur][nxt]);
                v[nxt] = false; 
            }
        }
    }

}
