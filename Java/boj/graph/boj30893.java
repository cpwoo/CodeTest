package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj30893 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int e;
    private static List<Integer> graph[], ret;
    private static boolean visited[];

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
        int s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n+1];
        visited[s] = true;

        ret = new ArrayList<>();

        Stack<Integer> stk = new Stack<>();
        stk.add(s);

        dfs(s, stk);

        Set<Integer> set = new HashSet<>(ret);

        for(int i=1; i<ret.size()-1; i+=2) {
            for(int nxt : graph[ret.get(i)]) {
                if(!set.contains(nxt)) {
                    bw.write("Second");
                    return;
                }
            }
        }
        bw.write("First");
    }

    private static void dfs(int cur, Stack<Integer> path) {
        if(cur == e) {
            ret.addAll(path);
            return;
        }

        for(int nxt : graph[cur]) {
            if(!visited[nxt]) {
                visited[nxt] = true;
                path.add(nxt);
                dfs(nxt, path);
                visited[nxt] = false;
                path.pop();
            }
        }
    }

}
