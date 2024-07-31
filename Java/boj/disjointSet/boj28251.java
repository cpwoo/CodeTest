package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj28251 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int parent[];
    private static long nadori[], power[];

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
        int q = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        nadori = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nadori[i] = Long.parseLong(st.nextToken());
        }

        power = new long[n];

        sb = new StringBuilder();
        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            sb.append(union(a, b)).append("\n");
        }

        bw.write(sb.toString());
    }

    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static long union(int a, int b) {
        a = find(a); b = find(b);
        if(a > b) {
            int tmp = a;
            a = b; b = tmp;
        }
        if(a != b) {
            power[a] = power[a]+power[b]+nadori[a]*nadori[b];
            nadori[a] = nadori[a]+nadori[b];
        }
        parent[b] = a;
        return power[a];
    }

}
