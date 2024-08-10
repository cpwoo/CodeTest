package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj20303 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int candy[];
    private static List<Integer> graph[];
    private static List<int[]> group;
    private static boolean v[];

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
        int k = Integer.parseInt(st.nextToken());

        candy = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) candy[i] = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a-1].add(b-1); graph[b-1].add(a-1);
        }

        group = new ArrayList<>();
        group.add(new int[]{0, 0});

        v = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!v[i]) group.add(bfs(i));
        }

        int L = group.size();
        int[][] dp = new int[L][k+1];

        for(int i=1; i<L; i++) {
            int children = group.get(i)[0], amount = group.get(i)[1];
            for(int j=1; j<k+1; j++) {
                if(j <= children) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j-children]+amount, dp[i-1][j]);
            }
        }

        bw.write(dp[L-1][k]+"");
    }

    private static int[] bfs(int x) {
        int[] tmp = new int[]{1, candy[x]};
        Deque<Integer> q = new ArrayDeque<>();
        q.add(x);
        v[x] = true;

        while(!q.isEmpty()) {
            int cur = q.pollFirst();
            for(Integer nxt : graph[cur]) {
                if(!v[nxt]) {
                    v[nxt] = true;
                    q.add(nxt);
                    tmp[0]++;
                    tmp[1] += candy[nxt];
                }
            }
        }

        return tmp;
    }

}
