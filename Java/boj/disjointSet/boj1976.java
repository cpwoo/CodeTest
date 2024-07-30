package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj1976 {
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
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        parent = new int[n+1];
        for(int i=0; i<n+1; i++) {
            parent[i] = i;
        }

        for(int y=1; y<n+1; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=1; x<n+1; x++) {
                int p = Integer.parseInt(st.nextToken());
                if(p == 1) union(y, x);
            }
        }

        int[] tour = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            tour[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> res = new HashSet<>();
        for(int t: tour) {
            res.add(find(t));
        }

        bw.write((res.size() == 1) ? "YES": "NO");
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
