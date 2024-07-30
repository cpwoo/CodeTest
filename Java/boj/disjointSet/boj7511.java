package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj7511 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int parent[];
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i=1; i<t+1; i++) {
            sb.append("Scenario ").append(i).append(":\n");
            solve();
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) != find(b)) union(a, b);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append((find(a) == find(b)) ? "1\n" : "0\n");
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
