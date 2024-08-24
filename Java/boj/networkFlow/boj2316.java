package CodeTest.Java.boj.networkFlow;

import java.io.*;
import java.util.*;

public class boj2316 {
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

        int M = 2*N;

        int[][] flow = new int[M][M];
        int[][] capacity = new int[M][M];

        List<Integer> connect[] = new ArrayList[M];
        for(int i=0; i<M; i++) connect[i] = new ArrayList<>();

        for(int i=0; i<N; i++) {
            connect[i].add(i+N);
            connect[i+N].add(i);
            capacity[i][i+N] = 1;
        }

        for(int i=0; i<P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            connect[a+N].add(b);
            connect[b].add(a+N);
            capacity[a+N][b] = 1;

            connect[b+N].add(a);
            connect[a].add(b+N);
            capacity[b+N][a] = 1;
        }

        int start = N, end = 1, ret = 0;

        int prev[], cur;
        Deque<Integer> q;

        while(true) {
            prev = new int[M];
            Arrays.fill(prev, -1);

            q = new ArrayDeque<>();
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
