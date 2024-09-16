package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16964 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Integer> graph[], d;
    private static boolean visited[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] ret = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) ret[i] = Integer.parseInt(st.nextToken());

        int[] order = new int[n+1];

        for(int i=0; i<n; i++) order[ret[i]] = i;

        for(int i=1; i<n+1; i++) Collections.sort(graph[i], (o1, o2) -> order[o1]-order[o2]);

        visited = new boolean[n+1];
        d = new ArrayList<>();
        dfs(1);

        boolean flag = true;
        for(int i=0; i<n; i++) {
            if(d.get(i) != ret[i]) {
                flag = false;
                break;
            }
        }

        bw.write((flag) ? "1" : "0");
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        d.add(cur);

        for(int nxt : graph[cur]) {
            if(visited[nxt]) continue;
            dfs(nxt);
        }
    }

}
