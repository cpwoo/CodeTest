package CodeTest.Java.boj.stronglyConnectedComponent;

import java.io.*;
import java.util.*;

public class boj4013 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Integer> graph[], reverseGraph[], group[];
    private static Stack<Integer> stk;
    private static boolean visited[];
    private static int cash[], sccNum[], sccArr[], sccVal[];

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

        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        reverseGraph = new ArrayList[n];
        for(int i=0; i<n; i++) reverseGraph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            graph[a].add(b);
            reverseGraph[b].add(a);
        }

        stk = new Stack<>();
        visited = new boolean[n];

        for(int i=0; i<n; i++) if(!visited[i]) DFS(i);

        cash = new int[n];
        for(int i=0; i<n; i++) cash[i] = Integer.parseInt(br.readLine());

        sccNum = new int[n];
        Arrays.fill(sccNum, -1);

        sccArr = new int[n];
        sccVal = new int[n];
        
        group = new ArrayList[n];
        for(int i=0; i<n; i++) group[i] = new ArrayList<>();
 
        int k = 0;
        while(!stk.isEmpty()) {
            int now = stk.pop();
            if(sccNum[now] == -1) {
                reverseDFS(now, k++);
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken())-1;
        int P = Integer.parseInt(st.nextToken());

        int[] result = new int[P];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<P; i++) result[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();
        q.add(sccNum[S]);
        
        int[] dp = new int[k];
        dp[sccNum[S]] = sccVal[sccNum[S]];

        while(!q.isEmpty()) {
            int now = q.pollFirst();
            for(Integer nxt : group[now]) {
                if(dp[nxt] < dp[now]+sccVal[nxt]) {
                    dp[nxt] = dp[now]+sccVal[nxt];
                    q.add(nxt);
                }
            }
        }

        int ret = 0;
        for(Integer r : result) {
            ret = Math.max(ret, dp[sccNum[r-1]]);
        }

        bw.write(ret+"");
    }

    private static void DFS(int node) {
        visited[node] = true;
        for(Integer nxt : graph[node]) {
            if(!visited[nxt]) DFS(nxt);
        }
        stk.add(node);
    }

    private static void reverseDFS(int node, int num) {
        sccNum[node] = num;
        sccArr[num]++;
        sccVal[num] += cash[node];
        for(Integer nxt : reverseGraph[node]) {
            if(sccNum[nxt] == -1) reverseDFS(nxt, num);
            else if(sccNum[node] != sccNum[nxt]) {
                group[sccNum[nxt]].add(sccNum[node]);
            }
        }
    }

}
