package CodeTest.Java.boj.topologicalSorting;

import java.io.*;
import java.util.*;

public class boj1948 {
    static class Node {
        int t, v;
        Node(int t, int v) {
            this.t = t;
            this.v = v;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static long dist[];
    private static boolean check[];
    private static List<Node> graph[];
    private static int ret;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        dist = new long[N+1];
        check = new boolean[N+1];

        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ret = 0;

        getMax(s); getCnt(s);

        bw.write(dist[s]+"\n"+ret+"");
    }

    private static void getMax(int start) {
        for(Node node : graph[start]) {
            if(dist[node.t] == 0) getMax(node.t);
            dist[start] = Math.max(dist[start], dist[node.t]+node.v);
        }
    }

    private static void getCnt(int start) {
        if(check[start]) return;
        check[start] = true;
        for(Node node : graph[start]) {
            if(dist[start] == dist[node.t]+node.v) {
                getCnt(node.t);
                ret++;
            }
        }
    }

}
