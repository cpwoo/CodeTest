package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj16562 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int p[], g[];

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
        int k = Integer.parseInt(st.nextToken());

        p = new int[n+1];
        for(int i=0; i<n+1; i++) p[i] = i;

        g = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) {
            g[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        int cost = 0;
        Set<Integer> friend = new HashSet<>();
        
        for(int i=1; i<n+1; i++) {
            if(!friend.contains(find(i))) {
                cost += g[p[i]];
                friend.add(p[i]);
            }
        }

        bw.write((cost <= k) ? cost+"" : "Oh no");
    }

    private static int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private static void union(int a, int b) {
        a = find(a); b = find(b);
        if(g[a] < g[b]) p[b] = a;
        else p[a] = b;
    }

}
