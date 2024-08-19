package CodeTest.Java.boj.stronglyConnectedComponent;

import java.io.*;
import java.util.*;

public class boj4196 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> graph[], reverseGraph[];
    private static Stack<Integer> stk;
    private static boolean visited[];
    private static int idx, ids[];

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

        for(int i=1; i<v+1; i++) if(!visited[i]) DFS(i);

        visited = new boolean[v+1];
        idx = 0;
        ids = new int[v+1];
        Arrays.fill(ids, -1);

        while(!stk.isEmpty()) {
            int x = stk.pop();
            if(!visited[x]) {
                idx++;
                reverseDFS(x);
            }
        }

        int[] sccIndegree = new int[idx+1];

        for(int i=1; i<v+1; i++) for(Integer ed : graph[i]) {
            if(ids[i] != ids[ed]) sccIndegree[ids[ed]]++;
        }

        int cnt = 0;
        for(int i=1; i<idx+1; i++) if(sccIndegree[i] == 0) cnt++;

        sb.append(cnt).append('\n');
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
        ids[cur] = idx;
        for(Integer nxt : reverseGraph[cur]) {
            if(!visited[nxt]) reverseDFS(nxt);
        }
    }

}
