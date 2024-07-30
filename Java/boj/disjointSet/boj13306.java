package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj13306 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int allNode[][];

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
        int q = Integer.parseInt(st.nextToken());

        allNode = new int[n+1][2];
        allNode[1][1] = 1;
        
        for(int i=2; i<n+1; i++) {
            int a = Integer.parseInt(br.readLine());
            allNode[i][0] = a;
            allNode[i][1] = i;
        }

        int[][] query = new int[n+q-1][3];
        
        for(int i=0; i<n+q-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) {
                int b = Integer.parseInt(st.nextToken());
                query[i][0] = x; query[i][1] = b;
            } else if(x == 1) {
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                query[i][0] = x; query[i][1] = c; query[i][2] = d;
            }
        }
        
        Stack<Boolean> stk = new Stack<>();

        for(int i=n+q-2; i>-1; i--) {
            int x = query[i][0];
            if(x == 0) {
                int b = query[i][1];
                allNode[b][1] = allNode[b][0];
            } else if(x == 1) {
                int c = query[i][1], d = query[i][2];
                stk.add(find(c) == find(d));
            }
        }

        sb = new StringBuilder();
        while(!stk.isEmpty()) {
            sb.append(stk.pop() ? "YES\n" : "NO\n");
        }

        bw.write(sb.toString());
    }

    private static int find(int x) {
        if(allNode[x][1] != x) {
            allNode[x][1] = find(allNode[x][0]);
            allNode[x][0] = allNode[x][1];
        }
        return allNode[x][1];
    }

}
