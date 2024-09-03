package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj13905 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int[] parent;

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

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] infos = new int[m][3];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) infos[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(infos, (o1, o2) -> o2[2]-o1[2]);

        parent = new int[n+1];
        for(int i=0; i<n+1; i++) parent[i] = i;

        List<int[]> graph[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int[] info : infos) {
            if(find(info[0]) != find(info[1])) {
                union(info[0], info[1]);
                graph[info[0]].add(new int[]{info[1], info[2]});
                graph[info[1]].add(new int[]{info[0], info[2]});
            }
        }

        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        Deque<Integer> q = new ArrayDeque<>();
        q.add(s);

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == e) break;

            for(int[] nxt : graph[cur]) {
                if(visited[nxt[0]] == Integer.MAX_VALUE) {
                    visited[nxt[0]] = Math.min(visited[cur], nxt[1]);
                    q.add(nxt[0]);
                }
            }
        }

        bw.write((visited[e] != Integer.MAX_VALUE) ? visited[e]+"" : "0");
    }

    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        a = find(a); b = find(b);
        parent[Math.max(a, b)] = Math.min(a, b);
    }

}
