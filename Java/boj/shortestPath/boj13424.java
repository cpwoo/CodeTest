package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj13424 {
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

    private static final int INF = Integer.MAX_VALUE;

    private static int n, friends[];
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

        int k = Integer.parseInt(br.readLine());

        friends = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) friends[i] = Integer.parseInt(st.nextToken());

        long[] ret = new long[n+1];
        Arrays.fill(ret, INF);

        long min = Long.MAX_VALUE;

        for(int i=1; i<n+1; i++) {
            ret[i] = dijkstra(i);
            min = Math.min(min, ret[i]);
        }

        for(int i=1; i<n+1; i++) {
            if(ret[i] == min) {
                sb.append(i).append('\n');
                return;
            }
        }
    }

    private static long dijkstra(int pos) {
        int[] cost = new int[n+1];
        Arrays.fill(cost, INF);
        cost[pos] = 0;

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(pos, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(cost[node.v] != node.w) continue;

            for(int[] nxt: graph[node.v]) {
                if(cost[nxt[0]] > node.w+nxt[1]) {
                    cost[nxt[0]] = node.w+nxt[1];
                    q.add(new Node(nxt[0], cost[nxt[0]]));
                }
            }
        }

        long sum = 0;
        for(int friend : friends) sum += cost[friend];

        return sum;
    }

}
