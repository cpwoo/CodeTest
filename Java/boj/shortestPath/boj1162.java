package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1162 {
    static class Node implements Comparable<Node> {
        int v, cnt;
        long w;
        Node(int v, long w, int cnt) {
            this.v = v;
            this.w = w;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node node) {
            if(this.w != node.w) return Long.compare(this.w, node.w);
            else if(this.v != node.v) return this.v-node.v;
            return this.cnt-node.cnt;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int k;
    private static List<int[]> graph[];
    private static long dist[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

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

        dist = new long[n+1][k+1];
        for(int i=0; i<n+1; i++) Arrays.fill(dist[i], Long.MAX_VALUE);

        dijkstra(1);

        long min = Long.MAX_VALUE;
        for(int i=0; i<k+1; i++) min = Math.min(min, dist[n][i]);
        
        bw.write(min+"");
    }

    private static void dijkstra(int start) {
        Queue<Node> q = new PriorityQueue<>();

        dist[start][0] = 0;
        q.add(new Node(start, 0, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(dist[node.v][node.cnt] < node.w) continue;

            for(int[] nxt : graph[node.v]) {
                long nw = nxt[1]+node.w;
                
                if(dist[nxt[0]][node.cnt] > nw) {
                    dist[nxt[0]][node.cnt] = nw;
                    q.add(new Node(nxt[0], nw, node.cnt));
                }

                if(node.cnt < k && dist[nxt[0]][node.cnt+1] > node.w) {
                    dist[nxt[0]][node.cnt+1] = node.w;
                    q.add(new Node(nxt[0], node.w, node.cnt+1));
                }
            }
        }
    }

}
