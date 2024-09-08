package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1707 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> graph[];
    private static int visited[];
    private static boolean check;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        for(int i=0; i<V+1; i++) graph[i] = new ArrayList<>();

        visited = new int[V+1];
        check = false;

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1; i<V+1; i++) {
            if(visited[i] == 0) {
                dfs(i, 1);
                if(check) break;
            }
        }

        sb.append((check) ? "NO\n" : "YES\n");
    }

    private static void dfs(int start, int group) {
        if(check) return;

        visited[start] = group;

        for(int i : graph[start]) {
            if(visited[i] == 0) dfs(i, -group);
            else if(visited[start] == visited[i]) {
                check = true;
                return;
            }
        }
    }

}
