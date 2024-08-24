package CodeTest.Java.boj.networkFlow;

import java.io.*;
import java.util.*;

public class boj3640 {
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
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int L = 2*v+1;

        int[][] flow = new int[L][L];
        int[][] capacity = new int[L][L];
        int[][] cost = new int[L][L];

        List<Integer> connect[] = new ArrayList[L];
        for(int i=0; i<L; i++) connect[i] = new ArrayList<>();

        for(int i=1; i<v+1; i++) {
            connect[i].add(i+v);
            connect[i+v].add(i);
            capacity[i][i+v] = 1;
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            connect[a+v].add(b);
            connect[b].add(a+v);
            capacity[a+v][b] = 1;

            cost[a+v][b] = c;
            cost[b][a+v] = -c;
        }

        int start = 1+v, end = v, ret = 0;

        int prev[], distance[], cur;
        boolean visited[];
        Deque<Integer> q;

        for(int i=0; i<2; i++) {
            prev = new int[L];
            Arrays.fill(prev, -1);

            distance = new int[L];
            Arrays.fill(distance, 987654321);
            distance[start] = 0;

            visited = new boolean[L];
            visited[start] = true;

            q = new ArrayDeque<>();
            q.add(start);

            while(!q.isEmpty()) {
                cur = q.pollFirst();
                visited[cur] = false;

                for(Integer nxt : connect[cur]) {
                    if(capacity[cur][nxt]-flow[cur][nxt] > 0 && distance[nxt] > distance[cur]+cost[cur][nxt]) {
                        distance[nxt] = distance[cur]+cost[cur][nxt];
                        prev[nxt] = cur;
                        if(!visited[nxt]) {
                            q.add(nxt);
                            visited[nxt] = true;
                        }
                    }
                }
            }

            cur = end;
            while(cur != start) {
                flow[prev[cur]][cur]++;
                flow[cur][prev[cur]]--;
                ret += cost[prev[cur]][cur];
                cur = prev[cur];
            }
        }

        sb.append(ret).append('\n');
    }

}
