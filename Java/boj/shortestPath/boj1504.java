package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1504 {
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

    private static int n;
    private static List<int[]> graph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long path1 = dijkstra(1, v1)+dijkstra(v1, v2)+dijkstra(v2, n);
        long path2 = dijkstra(1, v2)+dijkstra(v2, v1)+dijkstra(v1, n);

        if(path1 >= Integer.MAX_VALUE && path2 >= Integer.MAX_VALUE) bw.write("-1");
        
        else bw.write(Math.min(path1, path2)+"");
    }

    private static long dijkstra(int start, int end) {
        long[] dist = new long[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);        
        dist[start] = 0;

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(dist[node.v] < node.w) continue;

            for(int[] nxt : graph[node.v]) {
                int nw = nxt[1]+node.w;
                
                if(dist[nxt[0]] > nw) {
                    dist[nxt[0]] = nw;
                    q.add(new Node(nxt[0], nw));
                }
            }
        }

        return dist[end];
    }

}
