package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj15681 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> tree[];
    private static int count[];

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
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) tree[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b); tree[b].add(a);
        }

        count = new int[n+1];

        dfs(r);

        sb = new StringBuilder();
        for(int i=0; i<q; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(count[x]).append('\n');
        }

        bw.write(sb.toString());
    }

    private static void dfs(int x) {
        count[x] = 1;
        for(Integer i : tree[x]) if(count[i] == 0) {
            dfs(i); count[x] += count[i];
        }
    }

}
