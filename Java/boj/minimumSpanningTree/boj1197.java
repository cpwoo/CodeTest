package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj1197 {
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
        int V = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[][] edge = new int[S][3];
        for(int i=0; i<S; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) edge[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edge, (o1, o2) -> o1[2]-o2[2]);

        parent = new int[V+1];
        for(int i=0; i<V+1; i++) parent[i] = i;

        int ret = 0;

        for(int[] ed : edge) {
            if(find(ed[0]) != find(ed[1])) {
                union(ed[0], ed[1]);
                ret += ed[2];
            }
        }

        bw.write(ret+"");
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
