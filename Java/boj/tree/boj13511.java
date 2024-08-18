package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj13511 {
    static class Node {
        int u, w;
        Node(int u, int w) {
            this.u = u;
            this.w = w;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int depth[], h;
    private static long dp[][][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        List<Node> tree[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) tree[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new Node(b, c));
            tree[b].add(new Node(a, c));
        }

        int[][] parent = new int[n+1][2];
        depth = new int[n+1];

        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);

        while(!q.isEmpty()) {
            int cur = q.pollFirst();
            for(Node node : tree[cur]) {
                if(!visited[node.u]) {
                    q.add(node.u);
                    parent[node.u][0] = cur;
                    parent[node.u][1] = node.w;
                    depth[node.u] = depth[cur]+1;
                    visited[node.u] = true;
                }
            }
        }

        h = (int) Math.ceil(Math.log(n)/Math.log(2));
        dp = new long[n+1][h][2];

        for(int i=0; i<n+1; i++) {
            dp[i][0][0] = parent[i][0];
            dp[i][0][1] = parent[i][1];
        }

        for(int j=1; j<h; j++) for(int i=1; i<n+1; i++) {
            dp[i][j][0] = dp[(int)dp[i][j-1][0]][j-1][0];
            dp[i][j][1] = dp[i][j-1][1]+dp[(int)dp[i][j-1][0]][j-1][1];
        }

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(tc-- > 0) {
            query();
        }

        bw.write(sb.toString());
    }

    private static void query() throws Exception {
        st = new StringTokenizer(br.readLine());
        int cmd = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int a = u, b = v;
        if(depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int diff = depth[a]-depth[b];
        for(int i=0; i<h; i++) if((diff&(1<<i)) != 0) a = (int) dp[a][i][0];

        int lca = a;
        if(a != b) {
            for(int i=h-1; i>=0; i--) {
                if(dp[a][i][0] != dp[b][i][0]) {
                    a = (int) dp[a][i][0]; b = (int) dp[b][i][0];
                }
                lca = (int) dp[a][0][0];
            }
        }

        if(cmd == 1) {
            long cost = 0;
            int diffU = depth[u]-depth[lca], diffV = depth[v]-depth[lca];
            for(int i=0; i<h; i++) {
                if((diffU&(1<<i)) != 0) {
                    cost += dp[u][i][1];
                    u = (int) dp[u][i][0];
                }
                if((diffV&(1<<i)) != 0) {
                    cost += dp[v][i][1];
                    v = (int) dp[v][i][0];
                }
            }
            sb.append(cost).append('\n');
        }
        else {
            int k = Integer.parseInt(st.nextToken());
            if(k <= depth[u]-depth[lca]) {
                diff = k-1;
                for(int i=0; i<h; i++) if((diff&(1<<i)) != 0) {
                    u = (int) dp[u][i][0];
                }
                sb.append(u).append('\n');
            }
            else {
                diff = depth[u]+depth[v]-2*depth[lca]-k+1;
                for(int i=h-1; i>=0; i--) if((diff&(1<<i)) != 0) {
                    v = (int) dp[v][i][0];
                }
                sb.append(v).append('\n');
            }
        }
    }

}
