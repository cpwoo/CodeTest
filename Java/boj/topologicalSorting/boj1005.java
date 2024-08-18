package CodeTest.Java.boj.topologicalSorting;

import java.io.*;
import java.util.*;

public class boj1005 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] d = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) d[i] = Integer.parseInt(st.nextToken());

        List<Integer> graph[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        int[] degree = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            degree[y]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=1; i<n+1; i++) if(degree[i] == 0) {
            q.add(i); dp[i] = d[i];
        }

        while(!q.isEmpty()) {
            int p = q.pollFirst();
            for(Integer i : graph[p]) {
                degree[i]--;
                dp[i] = Math.max(dp[p]+d[i], dp[i]);
                if(degree[i] == 0) q.add(i);
            }
        }

        sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
    }

}
