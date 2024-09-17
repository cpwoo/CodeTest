package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj17071 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int max = 500_000;

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

        if(n == k) {
            bw.write("0");
            return;
        }

        int[][] visited = new int[max+1][2];
        for(int i=0; i<max+1; i++) Arrays.fill(visited[i], -1);

        Deque<Integer> q = new ArrayDeque<>();
        q.add(n);

        int time = 1;
        k += time;

        while(true) {
            if(k > max) break;

            int sz = q.size();
            while(sz-- > 0) {
                int cur = q.poll();
                for(int nxt : new int[]{cur-1, cur+1, 2*cur}) {
                    if(0 <= nxt && nxt <= max && visited[nxt][time%2] == -1) {
                        q.add(nxt);
                        visited[nxt][time%2] = time;
                    }
                }
            }

            if(visited[k][time%2] != -1) {
                bw.write(time+"");
                return;
            }

            time++;
            k += time;
        }

        bw.write("-1");
    }

}
