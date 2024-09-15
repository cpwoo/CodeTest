package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16437 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static char[] kind;
    private static int[] cnt;
    private static List<Integer> graph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        kind = new char[n+1];
        Arrays.fill(kind, 'S');

        cnt = new int[n+1];

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=2; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            kind[i] = st.nextToken().charAt(0);
            cnt[i] = Integer.parseInt(st.nextToken());
            graph[Integer.parseInt(st.nextToken())].add(i);
        }

        bw.write(dfs(1)+"");
    }

    private static long dfs(int cur) {
        long ret = 0;

        for(int nxt : graph[cur]) ret += dfs(nxt);

        if(kind[cur] == 'S' && cur != 1) ret += cnt[cur];
        else if(kind[cur] == 'W') ret = Math.max(0, ret-cnt[cur]);

        return ret;
    }

}
