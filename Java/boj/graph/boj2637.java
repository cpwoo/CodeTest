package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2637 {
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
        int n = Integer.parseInt(br.readLine());
        
        List<int[]> graph[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        int[][] ret = new int[n+1][n+1];
        int[] degree = new int[n+1];

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[b].add(new int[]{a, c});
            degree[a]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=1; i<n+1; i++) {
            if(degree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int[] node : graph[cur]) {
                int nxt = node[0], cost = node[1];
                
                boolean flag = true;
                for(int i=1; i <n+1; i++) {
                    if (ret[cur][i] != 0) {
                        flag = false;
                        break;
                    }
                }

                if(flag) ret[nxt][cur] += cost;
                else {
                    for(int i=1; i<n+1; i++) {
                        ret[nxt][i] += ret[cur][i]*cost;
                    }
                }

                degree[nxt]--;
                if(degree[nxt] == 0) q.add(nxt);
            }
        }

        sb = new StringBuilder();

        for(int i=0; i<n+1; i++) {
            if(ret[n][i] > 0) sb.append(i).append(' ').append(ret[n][i]).append('\n');
        }

        bw.write(sb.toString());
    }

}
