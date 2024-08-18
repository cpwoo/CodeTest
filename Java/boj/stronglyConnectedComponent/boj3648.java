package CodeTest.Java.boj.stronglyConnectedComponent;

import java.io.*;
import java.util.*;

public class boj3648 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> graph[];
    private static boolean check[];
    private static int visited[], CNF[], idx, sccNum;
    private static Stack<Integer> stk;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        while(br.ready()) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(solve(N, M)).append('\n');
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static String solve(int N, int M) throws Exception {
        graph = new ArrayList[2*N];
        for(int i=0; i<2*N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a < 0) a = N-a;
            if(b < 0) b = N-b;
            a--; b--;
            graph[(a+N)%(2*N)].add(b);
            graph[(b+N)%(2*N)].add(a);
        }
        graph[N].add(0);

        visited = new int[2*N];
        check = new boolean[2*N];

        idx = 1; sccNum = 0;

        CNF = new int[2*N];
        Arrays.fill(CNF, -1);

        stk = new Stack<>();

        for(int i=0; i<2*N; i++) if(visited[i] == 0) scc(i);

        for(int i=0; i<N; i++) if(CNF[i] == CNF[N+i]) return "no";

        return "yes";
    }

    private static int scc(int node) {
        visited[node] = idx++;
        stk.add(node);
        int root = visited[node];
        
        for(Integer nxt : graph[node]) {
            if(visited[nxt] == 0) root = Math.min(root, scc(nxt));
            else if(!check[nxt]) root = Math.min(root, visited[nxt]);
        }
        
        if(root == visited[node]) {
            while(true) {
                int x = stk.pop();
                check[x] = true;
                CNF[x] = sccNum;
                if(x == node) break;
            }
            sccNum++;
        }

        return root;
    }

}
