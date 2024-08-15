package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj1761 {
    static class Node {
        int u, dist;
        Node(int u, int dist) {
            this.u = u;
            this.dist = dist;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int LOG = 21;
    private static int n, parent[][], depth[], dpDists[];
    private static boolean chk[];

    private static List<Node> graph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        parent = new int[n+1][LOG];
        depth = new int[n+1];
        chk = new boolean[n+1];
        dpDists = new int[n+1];

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        depth[0] = -1;

        setParent();

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dpDists[a]+dpDists[b]-2*dpDists[LCA(a,b)]).append('\n');
        }

        bw.write(sb.toString());
    }

    private static void setParent() {
        findDepth(1, 0, 0);
        for(int i=1; i<LOG; i++) {
            for(int j=1; j<n+1; j++) {
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }

    private static void findDepth(int curNode, int parentNode, int value) {
        depth[curNode] = depth[parentNode]+1;

        chk[curNode] = true;
        
        if(curNode != 1) dpDists[curNode] += dpDists[parentNode]+value;
        
        for(Node nxt : graph[curNode]) {
            if(!chk[nxt.u]) {
                parent[nxt.u][0] = curNode;
                findDepth(nxt.u, curNode, nxt.dist);
            }
        }
    }

    private static int LCA(int a, int b) {
        if(depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        for(int i=LOG-1; i>=0; i--) {
            if(depth[b]-depth[a] >= (1<<i)) b = parent[b][i];
        }
        
        if(a == b) return a;

        for(int i=LOG-1; i>=0; i--) {
            if(parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        
        return parent[a][0];
    }

}
