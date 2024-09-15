package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj15591 {
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

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

        sb = new StringBuilder();
        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Deque<Integer> dq = new ArrayDeque<>();
            dq.add(v);

            boolean[] visited = new boolean[n+1];
            visited[v] = true;

            int cnt = 0;

            while(!dq.isEmpty()) {
                int cur = dq.poll();
                for(int[] node : graph[cur]) {
                    int nxt = node[0], cost = node[1];
                    if(!visited[nxt]) {
                        if(cost >= k) {
                            dq.add(nxt);
                            cnt++;
                            visited[nxt] = true;
                        } 
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
    }

}
