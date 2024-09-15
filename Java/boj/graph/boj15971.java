package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj15971 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

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
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        List<int[]> graph[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        boolean[] visited = new boolean[n+1];
        visited[start] = true;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0], tot = cur[1], max = cur[2];
            
            if(now == end) {
                bw.write(tot-max+"");
                break;
            }
            
            for(int[] node : graph[now]) {
                int nxt = node[0], cost = node[1];
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(new int[]{nxt, tot+cost, Math.max(max, cost)});
                }
            }
        }
    }

}
