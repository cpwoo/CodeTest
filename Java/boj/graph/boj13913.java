package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj13913 {
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
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();
        q.add(n);

        int[] visited = new int[100001];
        int[] chk = new int[100001];

        sb = new StringBuilder();

        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == k) {
                sb.append(visited[now]).append('\n');
                
                Stack<Integer> stk = new Stack<>();
                int tmp = now;
                
                for(int i=0; i<visited[now]+1; i++) {
                    stk.add(tmp);
                    tmp = chk[tmp];
                }

                while(!stk.isEmpty()) sb.append(stk.pop()).append(' ');

                break;
            }

            for(int nxt : new int[]{now-1, now+1, 2*now}) {
                if(0 <= nxt && nxt < 100001 && visited[nxt] == 0) {
                    visited[nxt] = visited[now]+1;
                    q.add(nxt);
                    chk[nxt] = now;
                }
            }
        }

        bw.write(sb.toString());
    }

}
