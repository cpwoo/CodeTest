package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2668 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static int n, arr[];
    private static boolean visited[];
    private static List<Integer> ret;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        for(int i=1; i<n+1; i++) arr[i] = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        ret = new ArrayList<>();

        for(int i=1; i<n+1; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        
        sb = new StringBuilder();
        sb.append(ret.size()).append('\n');

        for(int r : ret) sb.append(r).append('\n');

        bw.write(sb.toString());
    }

    private static void dfs(int v, int i) {
        if(!visited[arr[v]]) {
            visited[arr[v]] = true;
            dfs(arr[v], i);
            visited[arr[v]] = false;
        }

        if(arr[v] == i) ret.add(arr[v]);
    }

}
