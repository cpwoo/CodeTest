package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj1368 {
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
        int n = Integer.parseInt(br.readLine());
        
        Queue<Node> q = new PriorityQueue<>();
        for(int i=1; i<n+1; i++) {
            q.add(new Node(0, i, Integer.parseInt(br.readLine())));
        }

        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n+1; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                q.add(new Node(i, j, x));
            }
        }

        parent = new int[n+1];
        for(int i=0; i<n+1; i++) parent[i] = i;

        int ret = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(union(node.u, node.v)) ret += node.cost;
        }

        bw.write(ret+"");
    }

    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int a, int b) {
        a = find(a); b = find(b);
        
        if(a == b) return false;
        
        parent[b] = a;
        return true;
    }

}
