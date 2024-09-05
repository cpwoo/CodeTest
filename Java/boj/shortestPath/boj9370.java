package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj9370 {
    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            if(this.w != node.w) return this.w-node.w;
            return this.v-node.v;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int INF = 1_000_000_000;

    private static int n;
    private static List<int[]> graph[];

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
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        int[] first = dijkstra(s), gDijk = dijkstra(g), hDijk = dijkstra(h);

        List<Integer> ret = new ArrayList<>();

        for(int i=0; i<t; i++) {
            int x = Integer.parseInt(br.readLine());
            if(first[g]+gDijk[h]+hDijk[x] == first[x] || first[h]+hDijk[g]+gDijk[x] == first[x]) {
                ret.add(x);
            }
        }

        Collections.sort(ret);

        for(int r : ret) sb.append(r).append(' ');

        sb.append('\n');
    }

    private static int[] dijkstra(int start) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dp[start] = 0;

        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(dp[node.v] < node.w) continue;

            for(int[] nxt : graph[node.v]) {
                int cost = node.w+nxt[1];
                if(cost < dp[nxt[0]]) {
                    dp[nxt[0]] = cost;
                    q.add(new Node(nxt[0], cost));
                }
            }
        }

        return dp;
    }

}
