package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj10282 {
    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            if(this.w != node.w) return this.w-node.w;
            return this.v-node.v;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int INF = 1_000_000_000;

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
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<int[]> d[] = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) d[i] = new ArrayList<>();

        for(int i=0; i<D; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            d[b].add(new int[]{a, s});
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, INF);
        dp[C] = 0;

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(C, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();

            if(dp[node.v] < node.w) continue;

            for(int[] nxt : d[node.v]) {
                int cost = node.w+nxt[1];
                if(dp[nxt[0]] > cost) {
                    dp[nxt[0]] = cost;
                    q.add(new Node(nxt[0], cost));
                }
            }
        }

        int cnt = 0, ret = 0;
        for(int i : dp) {
            if(i != INF) {
                ret = Math.max(ret, i);
                cnt++;
            }
        }

        sb.append(cnt).append(' ').append(ret).append('\n');
    }

}
