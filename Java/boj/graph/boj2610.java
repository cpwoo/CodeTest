package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2610 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] dist = new int[n+1][n+1];
        for(int i=0; i<n+1; i++) Arrays.fill(dist[i], INF);

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = dist[b][a] = 1;
        }

        for(int i=0; i<n+1; i++) dist[i][i] = 0;

        for(int k=1; k<n+1; k++) for(int i=1; i<n+1; i++) for(int j=1; j<n+1; j++) {
            dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
        }

        Map<List<Integer>, int[]> map = new HashMap<>();
        for(int i=1; i<n+1; i++) {
            List<Integer> group = new ArrayList<>();
            int maxDist = 0;

            for(int j=1; j<n+1; j++) {
                if(dist[i][j] != INF) {
                    group.add(j);
                    maxDist = Math.max(maxDist, dist[i][j]);
                }
            }

            if(!map.containsKey(group)) {
                map.put(group, new int[]{i, maxDist});
            } 
            else {
                int[] currentRep = map.get(group);
                if(currentRep[1] > maxDist) {
                    map.put(group, new int[]{i, maxDist});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int[] rep : map.values()) result.add(rep[0]);

        Collections.sort(result);
        
        sb = new StringBuilder();
        sb.append(result.size()).append('\n');

        for(int res : result) sb.append(res).append('\n');

        bw.write(sb.toString());
    }

}
