package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj9694 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i=1; i<=tc; i++) {
            sb.append(String.format("Case #%d: ", i));
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> graph[] = new ArrayList[m];
        for(int i=0; i<m; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        q.add(new int[] {0, 0, -1});

        boolean[] visited = new boolean[m];
        
        int[] dp = new int[m];
        Arrays.fill(dp, -1);
        
        int[] prev = new int[m];
        Arrays.fill(prev, -1);

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cost = current[0], cur = current[1], from = current[2];

            if(visited[cur]) continue;
            
            visited[cur] = true;
            
            prev[cur] = from;

            if(cur == m-1) break;

            for(int[] nxt : graph[cur]) {
                int nxtNode = nxt[0], nxtCost = nxt[1];
                if(!visited[nxtNode]) q.add(new int[] {cost+nxtCost, nxtNode, cur});
            }
        }

        if(prev[m-1] == -1) sb.append("-1");
        else {
            List<Integer> path = new ArrayList<>();
            
            for(int at=m-1; at!=-1; at=prev[at]) path.add(at);

            Collections.reverse(path);
            
            for(int p : path) sb.append(p).append(' ');
        }


        sb.append('\n');
    }

}
