package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj4803 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> graph[];
    private static boolean v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = 1;
        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            int cnt = solve(N, M);

            if(cnt == 0) {
                sb.append(String.format("Case %d: No trees.\n", tc++));
            }
            else if(cnt == 1) {
                sb.append(String.format("Case %d: There is one tree.\n", tc++));
            }
            else {
                sb.append(String.format("Case %d: A forest of %d trees.\n", tc++, cnt));
            }
        }
        
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static int solve(int N, int M) throws Exception {
        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();

        v = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b); graph[b].add(a);
        }

        int cnt = 0;
        for(int i=1; i<N+1; i++) {
            if(!v[i]) {
                if(dfs(0, i)) cnt++;
            }
        }
        
        return cnt;
    }

    private static boolean dfs(int prev, int node) {
        v[node] = true;
        for(Integer i : graph[node]) {
            if(i == prev) continue;
            if(v[i]) return false;
            if(!dfs(node, i)) return false;
        }
        return true;
    }

}
