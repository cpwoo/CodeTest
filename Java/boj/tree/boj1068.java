package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj1068 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, arr[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        dfs(k);

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) set.add(arr[i]);

        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] != -2 && !set.contains(i)) cnt++;
        }

        bw.write(cnt+"");
    }

    private static void dfs(int x) {
        arr[x] = -2;
        for(int i=0; i<n; i++) if(x == arr[i]) dfs(i);
    }

}
