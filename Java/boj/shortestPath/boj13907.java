package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj13907 {
    static class Node implements Comparable<Node> {
        int v, w, cnt;
        Node(int v, int w, int cnt) {
            this.v = v;
            this.w = w;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node node) {
            if(this.w != node.w) return this.w-node.w;
            else if(this.v != node.v) return this.v-node.v;
            return this.cnt-node.cnt;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int INF = Integer.MAX_VALUE;

    private static int n, e, d[][], ret;
    private static List<int[]> graph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            a--; b--;
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        int[] tax = new int[k];
        for(int i=0; i<k; i++) tax[i] = Integer.parseInt(br.readLine());

        d = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(d[i], INF);

        ret = INF;
        dijkstra(s-1);

        sb = new StringBuilder();
        sb.append(ret).append('\n');

        for(int t : tax) {
            int min = INF;
            for(int j=0; j<n; j++) {
                if(d[e-1][j] != INF) d[e-1][j] += t*j;
                min = Math.min(min, d[e-1][j]);
            }
            sb.append(min).append('\n');
        }

        bw.write(sb.toString());
    }

    private static void dijkstra(int v) {
        d[v][0] = 0;

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(v, d[v][0], 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            boolean flag = false;
            
            for(int i=0; i<node.cnt; i++) {
                if(d[node.v][i] < node.w) {
                    flag = true;
                    break;
                }
            }

            if(flag || d[node.v][node.cnt] < node.w) continue;

            if(node.v == e-1) {
                ret = Math.min(ret, d[node.v][node.cnt]);
                continue;
            }

            for(int[] nxt: graph[node.v]) {
                int dist = node.w+nxt[1];
                if(node.cnt+1 < n && dist < d[nxt[0]][node.cnt+1]) {
                    d[nxt[0]][node.cnt+1] = dist;;
                    q.add(new Node(nxt[0], dist, node.cnt+1));
                }
            }
        }
    }

}
