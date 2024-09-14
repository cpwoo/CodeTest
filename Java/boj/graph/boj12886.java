package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj12886 {
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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if((a+b+c)%3 != 0) {
            bw.write("0");
            return;
        }

        int total = a+b+c;
        boolean[][] visited = new boolean[total+1][total+1];
        visited[a][b] = true;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a, b});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int z = total-(x+y);

            if(x == y && y == z) {
                bw.write("1");
                return;
            }

            for(int[] nxt : new int[][]{{x, y},{y,z},{x,z}}) {
                int i = nxt[0], j = nxt[1];
                if(i < j) {
                    j -= i;
                    i += i;
                }
                else if(i > j) {
                    i -= j;
                    j += j;
                }
                else continue;

                int k = total-(i+j);
                int min = Math.min(i, Math.min(j, k));
                int max = Math.max(i, Math.max(j, k));

                if(!visited[min][max]) {
                    q.add(new int[]{min, max});
                    visited[min][max] = true;
                }
            }
        }
        
        bw.write("0");
    }

}
