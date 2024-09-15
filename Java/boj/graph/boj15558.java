package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj15558 {
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

        boolean[][] lines = new boolean[2][n];
        for(int i=0; i<2; i++) {
            char[] inp = br.readLine().toCharArray();
            for(int j=0; j<n; j++) {
                lines[i][j] = (inp[j] == '1');
            }
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        boolean[][] visited = new boolean[2][n];
        
        int time = -1;
        boolean flag = false;

        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i=0; i<sz; i++) {
                int[] cur = q.poll();
                int d = cur[0], idx = cur[1];
                if(idx+1 >= n || idx+k >= n) {
                    flag = true;
                    break;
                }
                if(lines[d][idx+1] && !visited[d][idx+1]) {
                    q.add(new int[]{d, idx+1});
                    visited[d][idx+1] = true;
                }
                if(idx-1 > time+1 && lines[d][idx-1] && !visited[d][idx-1]) {
                    q.add(new int[]{d, idx-1});
                    visited[d][idx-1] = true;
                }
                if(lines[(d+1)%2][idx+k] && !visited[0][idx+k]) {
                    q.add(new int[]{(d+1)%2, idx+k});
                    visited[(d+1)%2][idx+k] = true;
                }
            }
            time++;
        }

        bw.write((flag) ? "1" : "0");
    }

}
