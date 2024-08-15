package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj1967 {
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

    private static int n;
    private static List<Node> graph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        bw.write(bfs(bfs(1)[0])[1]+"");
    }

    private static int[] bfs(int start) {
        int[] v = new int[n+1];
        Arrays.fill(v, -1);
        v[start] = 0;

        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.pollFirst();
            for(Node nxt : graph[cur]) {
                if(v[nxt.u] == -1) {
                    q.add(nxt.u);
                    v[nxt.u] = v[cur]+nxt.dist;
                }
            }
        }

        int idx = -1, max = -1;
        for(int i=0; i<n+1; i++) {
            if(max < v[i]) {
                max = v[i];
                idx = i;
            }
        }

        return new int[]{idx, max};
    }

}
