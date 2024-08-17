package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj3584 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int parent[], ret;
    private static boolean v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(tc-- > 0) {
            solve();
        }
        
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        v = new boolean[n+1];

        ret = 0;
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            parent[b] = a;
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dfs(a); dfs(b);

        sb.append(ret).append('\n');
    }

    private static void dfs(int num) {
        if(v[num]) {
            ret = num;
            return;
        }

        v[num] = true;
        if(parent[num] != 0) dfs(parent[num]);
    }

}
