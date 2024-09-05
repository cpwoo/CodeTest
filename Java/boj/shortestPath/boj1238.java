package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1238 {
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
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
        }

        int ret = 0;
        for(int i=1; i<n+1; i++) {
            int[] go = dijkstra(i), back = dijkstra(x);
            ret = Math.max(ret, go[x]+back[i]);
        }
        
        bw.write(ret+"");
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[n+1];
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

        return dist;
    }

}
