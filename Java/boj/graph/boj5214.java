package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj5214 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int len = 100_000;

    private static int n, k, m;
    private static List<Integer> graph[];

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
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[len+n+1];
        for(int i=0; i<len+n+1; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<m+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<k; j++) {
                int x = Integer.parseInt(st.nextToken());
                graph[i].add(x+len);
                graph[x+len].add(i);
            }
        }

        bw.write(bfs()+"");
    }

    private static int bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(len+1);

        boolean[] visited = new boolean[len+n+1];
        visited[len+1] = true;

        int cnt = 0;
        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i=0; i<sz; i++) {
                int cur = q.poll();
                if(cur == len+n) return cnt/2+1;

                for(int nxt : graph[cur]) {
                    if(visited[nxt]) continue;
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
            cnt++;
        }

        return -1;
    }

}
