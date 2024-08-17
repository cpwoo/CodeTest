package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj3176 {
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

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int N = Integer.parseInt(br.readLine());
        int K = (int) (Math.log(N)/Math.log(2))+1;

        List<Node> graph[] = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1});
        
        int[] depth = new int[N+1];
        depth[1] = 1;

        int[][][] dp = new int[N+1][K][3];

        while(!q.isEmpty()) {
            int idx = q.peekFirst()[0];
            int d = q.peekFirst()[1];
            q.pollFirst();

            for(Node node : graph[idx]) {
                if(depth[node.u] == 0) {
                    q.add(new int[]{node.u, d+1});
                    depth[node.u] = d+1;
                    dp[node.u][0][0] = idx;
                    dp[node.u][0][1] = node.w;
                    dp[node.u][0][2] = node.w;
                }
            }
        }

        for(int j=1; j<K; j++) for(int i=1; i<N+1; i++) {
            dp[i][j][0] = dp[dp[i][j-1][0]][j-1][0];
            dp[i][j][1] = Math.min(dp[i][j-1][1], dp[dp[i][j-1][0]][j-1][1]);
            dp[i][j][2] = Math.max(dp[i][j-1][2], dp[dp[i][j-1][0]][j-1][2]);
        }

        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(depth[a] > depth[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            int min = Integer.MAX_VALUE, max = 0;

            for(int i=K; i>=0; i--) {
                if(depth[b]-depth[a] >= (1<<i)) {
                    min = Math.min(min, dp[b][i][1]);
                    max = Math.max(max, dp[b][i][2]);
                    b = dp[b][i][0];
                }
            }

            if(a == b) {
                sb.append(min).append(' ').append(max).append('\n');
                continue;
            }

            for(int i=K-1; i>=0; i--) {
                if(dp[a][i][0] != dp[b][i][0]) {
                    min = Math.min(min, Math.min(dp[a][i][1], dp[b][i][1]));
                    max = Math.max(max, Math.max(dp[a][i][2], dp[b][i][2]));
                    a = dp[a][i][0]; b = dp[b][i][0];
                }
            }

            min = Math.min(min, Math.min(dp[a][0][1], dp[b][0][1]));
            max = Math.max(max, Math.max(dp[a][0][2], dp[b][0][2]));

            sb.append(min).append(' ').append(max).append('\n');
        }

        bw.write(sb.toString());
    }

}
