package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1277 {
    static class Node implements Comparable<Node> {
        int v;
        double w;
        Node(int v, double w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            if(this.w != node.w) return Double.compare(this.w, node.w);
            return this.v-node.v;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n;
    private static List<Node> graph[];

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
        int w = Integer.parseInt(st.nextToken());

        double m = Double.parseDouble(br.readLine());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        int[][] pos = new int[n+1][2];
        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) pos[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<n+1; i++) for(int j=1; j<n+1; j++) {
            double d = dist(pos[i][0], pos[i][1], pos[j][0], pos[j][1]);
            if(d <= m) {
                graph[i].add(new Node(j, d));
                graph[j].add(new Node(i, d));
            }
        }

        for(int i=0; i<w; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, 0));
            graph[b].add(new Node(a, 0));
        }
        
        bw.write(dijkstra()+"");
    }

    private static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
    }

    private static int dijkstra() {
        double[] dist = new double[n+1];
        Arrays.fill(dist, Double.MAX_VALUE);        
        dist[1] = 0;

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(dist[node.v] < node.w) continue;

            for(Node nxt : graph[node.v]) {
                double nw = nxt.w+node.w;
                
                if(dist[nxt.v] > nw) {
                    dist[nxt.v] = nw;
                    q.add(new Node(nxt.v, nw));
                }
            }
        }

        return (int) (dist[n]*1000);
    }

}
