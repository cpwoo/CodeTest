package CodeTest.Java.boj.topologicalSorting;

import java.io.*;
import java.util.*;

public class boj2623 {
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

        List<Integer> graph[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        int[] indegree = new int[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int[] tmp = new int[L];
            for(int j=0; j<L; j++) tmp[j] = Integer.parseInt(st.nextToken());

            for(int j=0; j<L-1; j++) {
                graph[tmp[j]].add(tmp[j+1]);
                indegree[tmp[j+1]]++;
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=1; i<n+1; i++) if(indegree[i] == 0) {
            q.add(i);
        }

        List<Integer> ret = new ArrayList<>();

        while(!q.isEmpty()) {
            int tmp = q.pollFirst();
            ret.add(tmp);
            for(Integer i : graph[tmp]) {
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }

        if(ret.size() == n) {
            sb = new StringBuilder();
            for(Integer i : ret) sb.append(i).append('\n');
            bw.write(sb.toString());
        }
        else bw.write('0');
    }

}
