package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj3830 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int parent[], dist[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            parent = new int[n+1];
            for(int i=0; i<n+1; i++) {
                parent[i] = i;
            }

            dist = new int[n+1];
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                find(p); find(q);
                
                if(cmd == '!') {
                    int r = Integer.parseInt(st.nextToken());
                    union(p, q, r);
                } else {
                    bw.write((parent[p] == parent[q]) ? dist[q]-dist[p]+"\n" : "UNKNOWN\n");
                }
            }
        }
    }

    private static int find(int x) {
        if(parent[x] != x) {
            int r = find(parent[x]);
            dist[x] += dist[parent[x]];
            parent[x] = r;
        }
        return parent[x];
    }

    private static void union(int x, int y, int k) {
        int xroot = find(x), yroot = find(y);
        if(xroot != yroot) {
            parent[yroot] = xroot;
            dist[yroot] = (dist[x]+k)-dist[y];
        }
    }

}
