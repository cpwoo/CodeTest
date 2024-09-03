package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj4386 {
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
        int n = Integer.parseInt(br.readLine());

        double[][] edges = new double[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) edges[i][j] = Double.parseDouble(st.nextToken());
        }

        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<n-1; i++) for(int j=i+1; j<n; j++) {
            nodes.add(new Node(i, j, dist(edges[i], edges[j])));
        }

        Collections.sort(nodes);

        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

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

    private static double dist(double[] i, double[] j) {
        return Math.sqrt(Math.pow(i[0]-j[0], 2)+Math.pow(i[1]-j[1], 2));
    }

}
