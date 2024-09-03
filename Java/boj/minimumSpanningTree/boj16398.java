package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj16398 {
    static class Node implements Comparable<Node> {
        int u, v, w;

        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            if(this.w != node.w) return this.w-node.w;
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

        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        List<Node> nodes = new ArrayList<>();
        for(int a=0; a<n; a++) for(int b=a+1; b<n; b++) {
            nodes.add(new Node(a, b, graph[a][b]));
        }

        Collections.sort(nodes);

        long ret = 0;

        for(Node node : nodes) {
            if(find(node.u) != find(node.v)) {
                union(node.u, node.v);
                ret += node.w;
            }
        }

        bw.write(ret+"");
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
