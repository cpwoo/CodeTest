package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj22856 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int left[], right[], lastNode;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        left = new int[n+1]; right = new int[n+1];

        int[] parent = new int[n+1];
        int nCnt = 0;


        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            left[a] = b;
            right[a] = c;

            if(b != -1) {
                parent[b] = a;
                nCnt++;
            }
            if(c != -1) {
                parent[c] = a;
                nCnt++;
            }
        }

        lastNode = 0;

        traverse(1);

        int move = 0;
        while(lastNode != 1) {
            move++;
            lastNode = parent[lastNode];
        }

        bw.write(2*nCnt-move+"");
    }

    private static void traverse(int node) {
        if(node == -1) return;
        traverse(left[node]);
        lastNode = node;
        traverse(right[node]);
    }

}
