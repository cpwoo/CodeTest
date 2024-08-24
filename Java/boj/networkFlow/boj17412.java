package CodeTest.Java.boj.networkFlow;

import java.io.*;
import java.util.*;

public class boj17412 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[][] flow = new int[N][N];
        int[][] capacity = new int[N][N];

        List<Integer> connect[] = new ArrayList[N];
        for(int i=0; i<N; i++) connect[i] = new ArrayList<>();

        for(int i=0; i<P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            
            connect[a].add(b);
            connect[b].add(a);
            capacity[a][b] = 1;
        }


        int start = 0, end = 1, ret = 0;

        int cur;
        int[] prev = new int[N];
        Deque<Integer> q = new ArrayDeque<>();

        while(true) {
            Arrays.fill(prev, -1);

            q.clear();
            q.add(start);

            while(!q.isEmpty()) {
                cur = q.pollFirst();

                if(cur == end) break;

                for(Integer nxt : connect[cur]) {
                    if(capacity[cur][nxt]-flow[cur][nxt] > 0 && prev[nxt] == -1) {
                        prev[nxt] = cur;
                        q.add(nxt);
                    }
                }
            }

            if(prev[end] == -1) break;

            cur = end;
            while(cur != start) {
                flow[prev[cur]][cur]++;
                flow[cur][prev[cur]]--;
                cur = prev[cur];
            }
            ret++;
        }

        bw.write(ret+"");
    }

}
