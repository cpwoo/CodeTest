package CodeTest.Java.boj.bipartiteMatching;

import java.io.*;
import java.util.*;

public class boj2188 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int d[];
    private static boolean v[];
    private static List<Integer> graph[];

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
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            for(int j=0; j<L; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        d = new int[m+1];
        
        for(int i=1; i<n+1; i++) {
            v = new boolean[n+1];
            dfs(i);
        }

        int cnt = 0;
        for(int i=1; i<m+1; i++) {
            cnt += (d[i] != 0) ? 1 : 0;
        }

        bw.write(cnt+"");
    }
    
    private static boolean dfs(int i) {
        if(v[i]) return false;
        v[i] = true;
        for(Integer j : graph[i]) {
            if(d[j] == 0 || dfs(d[j])) {
                d[j] = i;
                return true;
            }
        }
        return false;
    }

}
