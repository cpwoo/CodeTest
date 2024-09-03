package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj6497 {
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
    private static StringBuilder sb;

    private static int parent[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(m == 0 && n == 0) break;
            
            solve(m, n);
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve(int m, int n) throws Exception {
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes.add(new Node(u, v, w));
        }

        Collections.sort(nodes);

        parent = new int[m+1];
        for(int i=0; i<m+1; i++) parent[i] = i;

        int ret = 0;

        for(Node node : nodes) {
            if(find(node.u) != find(node.v)) union(node.u, node.v);
            else ret += node.w;
        }

        sb.append(ret).append('\n');
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
