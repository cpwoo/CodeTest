package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj12784 {
    static class Node {
        int nxt, weight;
        Node(int nxt, int weight) {
            this.nxt = nxt;
            this.weight = weight;
        }
    }

    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Node> graph[];
    private static boolean v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        v = new boolean[n+1];
        int ret = 0;
        for(Node node: graph[1]) ret += dfs(node.nxt, 1);

        sb.append(ret).append('\n');
    }

    private static int dfs(int cur, int bef) {
        int parentWeight = 0, childWeight = 0;

        for(Node node: graph[cur]) {
            if(node.nxt == bef) {
                parentWeight = node.weight;
                continue;
            }
            if(!v[node.nxt]) {
                v[node.nxt] = true;
                childWeight += dfs(node.nxt, cur);
            }
        }

        if(graph[cur].size() == 1) return parentWeight;

        return Math.min(parentWeight, childWeight);
    }

}
