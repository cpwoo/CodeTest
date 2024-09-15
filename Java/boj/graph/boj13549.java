package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj13549 {
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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();
        q.add(n);

        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        visited[n] = 0;

        while(!q.isEmpty()) {
            int s = q.poll();
            if(s == k) {
                bw.write(visited[s]+"");
                break;
            }
            if(0 <= s-1 && s-1 < 100001 && visited[s-1] == -1) {
                visited[s-1] = visited[s]+1;
                q.add(s-1);
            }
            if(0 < 2*s && 2*s < 100001 && visited[2*s] == -1) {
                visited[2*s] = visited[s];
                q.add(2*s);
            }
            if(0 <= s+1 && s+1 < 100001 && visited[s+1] == -1) {
                visited[s+1] = visited[s]+1;
                q.add(s+1);
            }
        }
    }

}
