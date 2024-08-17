package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj2250 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Integer> nodePerLevel[];
    private static int graph[][], idx;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        boolean[] parentCheck = new boolean[n];
        
        nodePerLevel = new ArrayList[n];
        for(int i=0; i<n; i++) nodePerLevel[i] = new ArrayList<>();

        graph = new int[10001][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(left != -1) parentCheck[left-1] = true;
            if(right != -1) parentCheck[right-1] = true;

            graph[node][0] = left;
            graph[node][1] = right;
        }

        int root = -1;
        for(int i=0; i<n; i++) if(!parentCheck[i]) {
            root = i+1;
            break;
        }
        
        idx = 1;
        inOrder(root, 0);

        int maxLevel = 0, maxLevelWidth = 0;

        for(int level=0; level<n; level++) {
            if(!nodePerLevel[level].isEmpty()) {
                int min = 10000, max = 0;
                for(Integer v : nodePerLevel[level]) {
                    min = Math.min(min, v);
                    max = Math.max(max, v);
                }
                int width = max-min+1;
                if(maxLevelWidth < width) {
                    maxLevelWidth = width;
                    maxLevel = level+1;
                }
            }
        }

        bw.write(maxLevel+" "+maxLevelWidth+"");
    }

    private static void inOrder(int node, int level) {
        int left = graph[node][0], right = graph[node][1];
        
        if(left != -1) inOrder(left, level+1);

        nodePerLevel[level].add(idx);
        idx++;

        if(right != -1) inOrder(right, level+1);
    }

}
