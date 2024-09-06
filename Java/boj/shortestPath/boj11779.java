package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj11779 {
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

    private static final int INF = Integer.MAX_VALUE;
    
    private static List<int[]> graph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);

        int[] nearest = new int[n+1];
        Arrays.fill(nearest, start);

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();

            if(distance[node.v] < node.w) continue;

            for(int[] nxt : graph[node.v]) {
                int cost = node.w+nxt[1];
                if(cost < distance[nxt[0]]) {
                    distance[nxt[0]] = cost;
                    nearest[nxt[0]] = node.v;
                    q.add(new Node(nxt[0], cost));
                }
            }
        }

        List<Integer> ret = new ArrayList<>();
        int tmp = end;
        while(true) {
            ret.add(tmp);
            if(tmp == start) break;
            tmp = nearest[tmp];
        }

        sb = new StringBuilder();

        sb.append(distance[end]).append('\n');
        
        sb.append(ret.size()).append('\n');
        
        for(int i=ret.size()-1; i>=0; i--) sb.append(ret.get(i)).append(' ');

        bw.write(sb.toString());
    }

}
