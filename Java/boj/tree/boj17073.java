package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj17073 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Integer> graph[];
    private static boolean visited[];
    private static int leaf;

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
        int w = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b); graph[b].add(a);
        }

        visited = new boolean[n+1];

        leaf = 0;
        bfs(1);
        bw.write((double)w/leaf+"");
    }

    private static void bfs(int x) {
        visited[x] = true;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(x);

        while(!q.isEmpty()) {
            int n = q.pollFirst();
            if(graph[n].size() == 1 && visited[graph[n].get(0)]) {
                leaf++;
            }
            for(Integer i : graph[n]) if(!visited[i]) {
                visited[i] = true; q.add(i);
            }
        }
    }

}
