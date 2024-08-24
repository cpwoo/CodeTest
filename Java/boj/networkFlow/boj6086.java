package CodeTest.Java.boj.networkFlow;

import java.io.*;
import java.util.*;

public class boj6086 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        while(br.ready()) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        int[][] capacity = new int[52][52];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = st.nextToken().charAt(0)-'a';
            int e = st.nextToken().charAt(0)-'a';
            int c = Integer.parseInt(st.nextToken());

            if(s < 0) s += 58;
            if(e < 0) e += 58;

            capacity[s][e] += c;
            capacity[e][s] += c;
        }

        int ret = 0;
        int[] route = new int[52];
        int[][] cur = new int[52][52];
        Deque<Integer> q = new ArrayDeque<>();

        while(true) {
            Arrays.fill(route, -1);
            route[26] = 26;
            q.clear();
            q.add(26);

            while(!q.isEmpty()) {
                int now = q.pollFirst();
                for(int i=0; i<52; i++) {
                    if(capacity[now][i]-cur[now][i] > 0 && route[i] == -1) {
                        q.add(i);
                        route[i] = now;
                    }
                }
            }

            if(route[51] == -1) break;

            int flow = Integer.MAX_VALUE;

            for(int i=51; i!=26; i=route[i]) {
                flow = Math.min(flow, capacity[route[i]][i]-cur[route[i]][i]);
            }

            for(int i=51; i!=26; i=route[i]) {
                cur[route[i]][i] += flow;
                cur[i][route[i]] -= flow;
            }

            ret += flow;
        }

        bw.write(ret+"");
    }

}
