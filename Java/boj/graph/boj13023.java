package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj13023 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Integer> graph[];
    private static boolean visited[], flag;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[2001];
        flag = false;

        for(int i=0; i<n; i++) {
            dfs(i, 0);
            visited[i] = false;
            if(flag) break;
        }

        bw.write((flag) ? "1" : "0");
    }

    private static void dfs(int idx, int depth) {
        visited[idx] = true;
        if(depth == 4) {
            flag = true;
            return;
        }
        for(int i : graph[idx]) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, depth+1);
                visited[i] = false;
            }
        }
    }

}
