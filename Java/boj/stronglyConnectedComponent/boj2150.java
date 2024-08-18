package CodeTest.Java.boj.stronglyConnectedComponent;

import java.io.*;
import java.util.*;

public class boj2150 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> graph[], reverseGraph[], scc;
    private static boolean visited[];
    private static Stack<Integer> stk;

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
        
        reverseGraph = new ArrayList[v+1];
        for(int i=0; i<v+1; i++) reverseGraph[i] = new ArrayList<>();

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            reverseGraph[b].add(a);
        }

        stk = new Stack<>();
        visited = new boolean[v+1];

        for(int i=1; i<v+1; i++) {
            if(!visited[i]) DFS(i);
        }

        visited = new boolean[v+1];
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        while(!stk.isEmpty()) {
            scc = new ArrayList<>();
            int node = stk.pop();
            if(!visited[node]) {
                reverseDFS(node);
                Collections.sort(scc);
                map.put(scc.get(0), scc);
            }
        }

        sb = new StringBuilder();
        sb.append(map.size()).append('\n');

        for(Integer i : map.keySet()) {
            List<Integer> value = map.get(i);
            for(Integer val : value) {
                sb.append(val).append(' ');
            }
            sb.append("-1").append('\n');
        }

        bw.write(sb.toString());
    }

    private static void DFS(int cur) {
        visited[cur] = true;
        for(Integer nxt : graph[cur]) {
            if(!visited[nxt]) DFS(nxt);
        }
        stk.add(cur);
    }

    private static void reverseDFS(int cur) {
        visited[cur] = true;
        scc.add(cur);
        for(Integer nxt : reverseGraph[cur]) {
            if(!visited[nxt]) reverseDFS(nxt);
        }
    }

}
