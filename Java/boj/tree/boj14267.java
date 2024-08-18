package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj14267 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> graph[];
    private static int plus[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] boss = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) boss[i] = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<N; i++) if(boss[i] != -1) graph[boss[i]-1].add(i);

        plus = new int[N];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            plus[a-1] += b;
        }

        dfs(0, 0);

        sb = new StringBuilder();
        for(int i=0; i<N; i++) sb.append(plus[i]).append(' ');

        bw.write(sb.toString());
    }

    private static void dfs(int idx, int cur) {
        plus[idx] += cur;
        for(Integer g : graph[idx]) dfs(g, plus[idx]);
    }

}
