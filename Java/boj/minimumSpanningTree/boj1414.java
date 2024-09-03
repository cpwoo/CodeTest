package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj1414 {
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

        char[][] data = new char[n][n];
        for(int i=0; i<n; i++) data[i] = br.readLine().toCharArray();

        List<Node> graph = new ArrayList<>();

        int ret = 0;

        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(data[i][j] == '0') graph.add(new Node(i+1, j+1, 0));
            else {
                char x = data[i][j];
                if('a' <= x && x <= 'z') {
                    graph.add(new Node(i+1, j+1, x-'a'+1));
                    ret += x-'a'+1;
                }
                else if('A' <= x && x <= 'Z') {
                    graph.add(new Node(i+1, j+1, x-'A'+27));
                    ret += x-'A'+27;
                }
            }
        }

        Collections.sort(graph);

        parent = new int[n+1];
        for(int i=0; i<n+1; i++) parent[i] = i;

        for(Node node : graph) {
            if(node.cost == 0) continue;

            if(find(node.u) != find(node.v)) {
                union(node.u, node.v);
                ret -= node.cost;
            }
            else continue;
        }

        boolean chk = true;
        for(int i=1; i<n+1; i++) {
            if(find(i) != 1) {
                chk = false;
                break;
            }
        }

        bw.write((chk) ? ret+"" : "-1");
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
