package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj1647 {
    static class Node implements Comparable<Node> {
        int u, v, cost;

        Node(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            if(this.cost != node.cost) return this.cost-node.cost;
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

        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.add(new Node(a, b, c));
        }

        Collections.sort(nodes);

        parent = new int[n+1];
        for(int i=0; i<n+1; i++) parent[i] = i;

        List<Integer> lst = new ArrayList<>();

        for(Node node : nodes) {
            if(find(node.u) != find(node.v)) {
                union(node.u, node.v);
                lst.add(node.cost);
            }
        }

        int ret = 0;

        for(int i=0; i<lst.size()-1; i++) ret += lst.get(i);

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
