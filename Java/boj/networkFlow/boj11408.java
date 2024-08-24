package CodeTest.Java.boj.networkFlow;

import java.io.*;
import java.util.*;

public class boj11408 {
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
        int M = Integer.parseInt(st.nextToken());

        int start = 0, end = N+M+1;
        int L = end+1;

        int[][] flow = new int[L][L];
        int[][] capacity = new int[L][L];
        int[][] cost = new int[L][L];

        List<Integer> connect[] = new ArrayList[L];
        for(int i=0; i<L; i++) connect[i] = new ArrayList<>();

        for(int i=1; i<N+1; i++) {
            connect[i].add(start);
            connect[start].add(i);
            capacity[start][i] = 1;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int k=0; k<n; k++) {
                int j = Integer.parseInt(st.nextToken())+N;
                int c = Integer.parseInt(st.nextToken());

                connect[i].add(j);
                connect[j].add(i);
                capacity[i][j] = 1;

                cost[i][j] = c;
                cost[j][i] = -c;
            }
        }

        for(int i=N+1; i<N+M+1; i++) {
            connect[i].add(end);
            connect[end].add(i);
            capacity[i][end] = 1;
        }

        int[] ret = new int[2];

        int cur;
        int[] prev = new int[L];
        int[] distance = new int[L];
        boolean[] visited = new boolean[L];
        Deque<Integer> q = new ArrayDeque<>();

        while(true) {
            Arrays.fill(prev, -1);

            Arrays.fill(distance, 987654321);
            distance[start] = 0;

            Arrays.fill(visited, false);
            visited[start] = true;

            q.clear();
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

            if(prev[end] == -1) break;

            cur = end;
            while(cur != start) {
                flow[prev[cur]][cur]++;
                flow[cur][prev[cur]]--;
                ret[1] += cost[prev[cur]][cur];
                cur = prev[cur];
            }
            ret[0]++;
        }

        bw.write(ret[0]+"\n"+ret[1]+"");
    }

}
