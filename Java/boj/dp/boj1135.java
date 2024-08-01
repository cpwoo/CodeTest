package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1135 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int dp[];
    private static List<Integer> tree[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) parent[i] = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n];
        for(int i=0; i<n; i++) tree[i] = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(parent[i] != -1) tree[parent[i]].add(i);
        }

        dp = new int[n];
        dfs(0);
        bw.write(dp[0]+"");
    }

    private static void dfs(int cur) {
        List<Integer> child = new ArrayList<>();
        for(int nxt: tree[cur]) {
            dfs(nxt);
            child.add(dp[nxt]);
        }
        if(!child.isEmpty()) {
            Collections.sort(child, Collections.reverseOrder());
            int max = Integer.MIN_VALUE;
            for(int i=0; i<child.size(); i++) {
                max = Math.max(max, child.get(i)+i+1);
            }
            dp[cur] = max;
        }
    }

}
