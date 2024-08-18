package CodeTest.Java.boj.topologicalSorting;

import java.io.*;
import java.util.*;

public class boj1766 {
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
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n+1];
        
        List<Integer> graph[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1; i<n+1; i++) if(indegree[i] == 0) q.add(i);

        sb = new StringBuilder();

        while(!q.isEmpty()) {
            int tmp = q.poll();
            sb.append(tmp).append(' ');
            for(Integer i : graph[tmp]) {
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }

        bw.write(sb.toString());
    }

}
