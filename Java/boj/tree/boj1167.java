package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj1167 {
    static class Node {
        int u, dist;
        Node(int u, int dist) {
            this.u = u;
            this.dist = dist;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Node> graph[];
    private static int v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            while(true) {
                int p = Integer.parseInt(st.nextToken());
                if(p == -1) break;
                int q = Integer.parseInt(st.nextToken());
                graph[x].add(new Node(p, q));
            }
        }

        v = new int[n+1];
        Arrays.fill(v, -1);
        v[1] = 0;

        dfs(1, 0);

        int start = -1, max = -1;
        for(int i=0; i<n+1; i++) {
            if(max < v[i]) {
                max = v[i];
                start = i;
            }
        }

        v = new int[n+1];
        Arrays.fill(v, -1);
        v[start] = 0;
        dfs(start, 0);

        max = -1;
        for(int i=0; i<n+1; i++) max = Math.max(max, v[i]);

        bw.write(max+"");
    }

    private static void dfs(int x, int y) {
        for(Node node : graph[x]) {
            if(v[node.u] == -1) {
                v[node.u] = node.dist+y;
                dfs(node.u, node.dist+y);
            }
        }
    }

}
