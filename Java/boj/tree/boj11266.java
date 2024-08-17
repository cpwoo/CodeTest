package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj11266 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> graph[];
    private static Set<Integer> cutVertex, candidates;
    private static int visited[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v+1];
        for(int i=0; i<v+1; i++) graph[i] = new ArrayList<>();

        cutVertex = new HashSet<>();
        candidates = new HashSet<>();

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b); graph[b].add(a);
            candidates.add(a); candidates.add(b); 
        }

        visited = new int[v+1];

        for(Integer vertex : candidates) {
            if(visited[vertex] == 0) dfs(vertex, 1);
        }

        sb = new StringBuilder();
        sb.append(cutVertex.size()).append('\n');

        List<Integer> ret = new ArrayList<>(cutVertex);
        Collections.sort(ret);
        for (Integer i : ret) sb.append(i).append(' ');

        bw.write(sb.toString());
    }

    private static int dfs(int cur, int cnt) {
        visited[cur] = cnt;

        int child = 0, ret = visited[cur];

        for(Integer nxt : graph[cur]) {
            if(visited[nxt] != 0) ret = Math.min(ret, visited[nxt]);
            else {
                child++;
                int subTree = dfs(nxt, cnt+1);

                if(cnt != 1 && subTree >= visited[cur]) cutVertex.add(cur);

                ret = Math.min(ret, subTree);
            }
        }

        if(cnt == 1 && child >= 2) cutVertex.add(cur);

        return ret;
    }

}
