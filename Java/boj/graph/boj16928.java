package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16928 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int graph[], visited[];

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
        int m = Integer.parseInt(st.nextToken());

        graph = new int[101];
        for(int i=0; i<101; i++) graph[i] = i;

        for(int i=0; i<n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a] = b;
        }

        visited = new int[101];
        bfs(1);

        bw.write(visited[100]-1+"");
    }

    private static void bfs(int v) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(v);

        visited[v] = 1;

        while(!q.isEmpty()) {
            int target = q.poll();
            for(int i=1; i<7; i++) {
                int dice = target+i;
                if(dice > 100) continue;
                int cnt = graph[dice];

                if(visited[cnt] == 0) {
                    q.add(cnt);
                    visited[cnt] = visited[target]+1;
                    if(cnt == 100) return;
                }
            }
        }
    }

}
