package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj13418 {
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
        int m = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m+1][3];
        for(int i=0; i<m+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) edges[i][j] = Integer.parseInt(st.nextToken());
        }

        int worst = 0, best = n;

        int[] maxParent = new int[n+1], minParent = new int[n+1];
        
        for(int i=0; i<n+1; i++) maxParent[i] = minParent[i] = i;

        for(int i=0; i<m+1; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if(w == 1) {
                u = find(u, minParent); v = find(v, minParent);
                if(u != v) {
                    best--;
                    union(u, v, minParent);
                }
            }
            else {
                u = find(u, maxParent); v = find(v, maxParent);
                if(u != v) {
                    worst++;
                    union(u, v, maxParent);
                }
            }
        }

        bw.write(worst*worst-best*best+"");
    }

    private static int find(int x, int[] parent) {
        if(parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private static void union(int a, int b, int[] parent) {
        a = find(a, parent); b = find(b, parent);
        parent[Math.max(a, b)] = Math.min(a, b);
    }

}
