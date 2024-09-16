package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16947 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> graph[];
    private static boolean visited[], cycle;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] cycleStation = new boolean[n];

        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            cycle = false;
            circulationStation(i, i, 0);
            if(cycle) cycleStation[i] = true;
        }

        int[] chk = new int[n];
        Arrays.fill(chk, -1);

        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            if(cycleStation[i]) {
                chk[i] = 0;
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i : graph[now]) {
                if(chk[i] == -1) {
                    q.add(i);
                    chk[i] = chk[now]+1;
                }
            }
        }

        sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(chk[i]).append(' ');

        bw.write(sb.toString());
    }

    private static void circulationStation(int start, int idx, int cnt) {
        if(start == idx && cnt >= 2) {
            cycle = true;
            return;
        }

        visited[idx] = true;

        for(int i : graph[idx]) {
            if(!visited[i]) circulationStation(start, i, cnt+1);
            else if(i == start && cnt >= 2) circulationStation(start, i, cnt);
        }
    }

}
