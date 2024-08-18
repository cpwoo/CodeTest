package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj20924 {
    static class Node {
        int v, d;
        Node(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Node> graph[];
    private static int r, ret[];

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
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        ret = new int[2];

        dfs(r, r, 0, 0);

        bw.write(ret[0]+" "+ret[1]+"");
    }

    private static void dfs(int u, int p, int s, int f) {
        if(f == 0) ret[0] = s;
        else ret[1] = Math.max(ret[1], s);

        if(f == 0 && graph[u].size() > 2-(u==r?1:0)) {
            f = 1; s = 0;
        }
        for(Node node : graph[u]) {
            if(node.v == p) continue;
            dfs(node.v, u, s+node.d, f);
        }
    }

}
