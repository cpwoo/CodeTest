package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj4485 {
    static class Node implements Comparable<Node> {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            if(this.cost != node.cost) return this.cost-node.cost;
            else if(this.x != node.x) return this.x-node.x;
            return this.y-node.y;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int INF = 1_000_000_000;
    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int cnt, n, graph[][], dp[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();

        cnt = 1;
        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            graph = new int[n][n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) graph[i][j] = Integer.parseInt(st.nextToken());
            }

            dp = new int[n][n];
            for(int i=0; i<n; i++) Arrays.fill(dp[i], INF);

            dijkstra();

            cnt++;
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void dijkstra() {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, graph[0][0]));
        dp[0][0] = 0;

        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(node.x == n-1 && node.y == n-1) {
                sb.append(String.format("Problem %d: %d\n", cnt, dp[node.x][node.y]));
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = node.x+dx[i], ny = node.y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                    int nxtCost = node.cost+graph[nx][ny];
                    if(nxtCost < dp[nx][ny]) {
                        dp[nx][ny] = nxtCost;
                        q.add(new Node(nx, ny, nxtCost));
                    }
                }
            }
        }
    }

}
