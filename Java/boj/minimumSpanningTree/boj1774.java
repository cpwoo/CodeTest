package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj1774 {
    static class Node implements Comparable<Node> {
        int u, v;
        double d;

        Node(int u, int v, double d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Node node) {
            if(this.d != node.d) return Double.compare(this.d, node.d);
            else if(this.u != node.u) return this.u-node.u;
            return this.v-node.v;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int parent[];

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

        parent = new int[n+1];
        for(int i=0; i<n+1; i++) parent[i] = i;

        int[][] edges = new int[n+1][2];
        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) edges[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        List<Node> nodes = new ArrayList<>();
        for(int i=1; i<n; i++) for(int j=i+1; j<n+1; j++) {
            nodes.add(new Node(i, j, dist(edges[i], edges[j])));
        }

        Collections.sort(nodes);

        double ret = 0;

        for(Node node : nodes) {
            if(find(node.u) != find(node.v)) {
                union(node.u, node.v);
                ret += node.d;
            }
        }

        bw.write(String.format("%.2f", ret));
    }

    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        a = find(a); b = find(b);
        parent[Math.max(a, b)] = Math.min(a, b);
    }

    private static double dist(int[] i, int[] j) {
        return Math.sqrt(Math.pow(i[0]-j[0], 2)+Math.pow(i[1]-j[1], 2));
    }

}
