package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj1717 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int parent[];

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
        
        parent = new int[n+1];
        for(int i=0; i<n+1; i++) {
            parent[i] = i;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(q == 0) union(a, b);
            else if(q == 1) {
                bw.write((find(a) == find(b)) ? "YES\n" : "NO\n");
            }
        }
    }


    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        a = find(a); b = find(b);
        parent[Math.max(a, b)] = Math.min(a, b);
    }

}
