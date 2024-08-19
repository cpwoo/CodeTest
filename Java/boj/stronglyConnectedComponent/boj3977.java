package CodeTest.Java.boj.stronglyConnectedComponent;

import java.io.*;
import java.util.*;

public class boj3977 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> graph[], reverseGraph[], scc;
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
            if(tc != 0) br.readLine();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        reverseGraph = new ArrayList[n];
        for(int i=0; i<n; i++) reverseGraph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            reverseGraph[b].add(a);
        }

        stk = new Stack<>();
        visited = new boolean[n];

        for(int i=0; i<n; i++) if(!visited[i]) DFS(i);

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        visited = new boolean[n];
        idx = -1;
        ids = new int[n];
        Arrays.fill(ids, -1);

        while(!stk.isEmpty()) {
            scc = new ArrayList<>();
            int x = stk.pop();
            if(!visited[x]) {
                idx++;
                reverseDFS(x);
                map.put(idx, scc);
            }
        }

        int[] sccIndegree = new int[idx+1];

        for(int i=0; i<n; i++) for(Integer ed : graph[i]) {
            if(ids[i] != ids[ed]) sccIndegree[ids[ed]]++;
        }

        int cnt = 0;
        List<Integer> tmp = new ArrayList<>();
        for(int i=0; i<idx+1; i++) {
            if(sccIndegree[i] == 0) {
                for(Integer val : map.get(i)) {
                    tmp.add(val);
                }
                cnt++;
            }
        }

        Collections.sort(tmp);

        if(cnt == 1) {
            for(Integer t : tmp) sb.append(t).append('\n');
        }
        else {
            sb.append("Confused").append('\n');
        }

        sb.append('\n');
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
        scc.add(cur);
        for(Integer nxt : reverseGraph[cur]) {
            if(!visited[nxt]) reverseDFS(nxt);
        }
    }

}
