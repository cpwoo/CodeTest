package CodeTest.Java.boj.stronglyConnectedComponent;

import java.io.*;
import java.util.*;

public class boj11281 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int n, parent[], compare[], num, V, CNF[];
    private static boolean visited[];
    private static Stack<Integer> stk;
    private static List<Integer> graph[], sccArr[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[2*n+1];
        compare = new int[2*n+1];
        visited = new boolean[2*n+1];
        stk = new Stack<>();
        num = 0; V = 0;
        CNF = new int[2*n+1];
        Arrays.fill(CNF, -1);

        graph = new ArrayList[2*n+1];
        for(int i=0; i<2*n+1; i++) graph[i] = new ArrayList<>();

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[validate(-u)].add(validate(v));
            graph[validate(-v)].add(validate(u));
        }

        sccArr = new ArrayList[2*n+1];
        for(int i=0; i<2*n+1; i++) sccArr[i] = new ArrayList<>();

        for(int i=1; i<2*n+1; i++) if(!visited[i]) scc(i);

        for(int i=1; i<n+1; i++) {
            if(compare[i] == compare[i+n]) {
                bw.write('0');
                return;
            }
        }

        sb = new StringBuilder();
        sb.append(1).append('\n');

        for(int i=V-1; i>=0; i--) {
            for(Integer j : sccArr[i]) {
                int now = Math.abs(validate(j));
                if(CNF[now] == -1) {
                    CNF[now] = (j > n) ? 1 : 0;
                }
            }
        }

        for(int i=1; i<n+1; i++) sb.append(CNF[i]).append(' ');

        bw.write(sb.toString());
    }

    private static int validate(int x) {
        return (0 < x && x < n+1) ? x : -x+n;
    }

    private static int scc(int idx) {
        int root = parent[idx] = ++num;
        stk.add(idx);

        for(Integer nxt : graph[idx]) {
            if(parent[nxt] == 0) root = Math.min(root, scc(nxt));
            else if(!visited[nxt]) root = Math.min(root, parent[nxt]);
        }

        if(root == parent[idx]) {
            List<Integer> tmp = new ArrayList<>();
            while(!stk.isEmpty()) {
                int x = stk.pop();
                tmp.add(x);
                visited[x] = true;
                compare[x] = V;

                if(x == idx) break;
            }
            sccArr[V++] = tmp;
        }

        return root;
    }

}
