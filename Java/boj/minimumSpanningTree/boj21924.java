package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj21924 {
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Node> q = new PriorityQueue<>();
        long total = 0;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            total += c;
            q.add(new Node(a, b, c));
        }

        long mst = 0;
        int edgeCnt = 0;

        parent = new int[n+1];
        for(int i=0; i<n+1; i++) parent[i] = i;

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(union(node.u, node.v)) {
                mst += node.w;
                edgeCnt++;
                if(edgeCnt == n-1) break;
            }
        }

        bw.write((edgeCnt == n-1) ? total-mst+"" : "-1");
    }

    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int a, int b) {
        a = find(a); b = find(b);
        parent[Math.max(a, b)] = Math.min(a, b);
        return a != b;
    }

}
