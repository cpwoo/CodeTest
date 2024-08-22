package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj2268 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static long tree[];

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

        tree = new long[4*n];

        sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(q == 0) {
                if(a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                sb.append(sum(1, 0, n-1, a-1, b-1)).append('\n');
            }
            else modify(1, 0, n-1, a-1, b);
        }

        bw.write(sb.toString());
    }

    private static long sum(int node, int start, int end, int left, int right) {
        if(left > end || right < start) return 0;

        if(left <= start && right >= end) return tree[node];

        int mid = (start+end)/2;

        return sum(2*node, start, mid, left, right)+sum(2*node+1, mid+1, end, left, right);
    }

    private static void modify(int node, int start, int end, int idx, int value) {
        if(idx < start || idx > end) return;

        if(start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start+end)/2;
        modify(2*node, start, mid, idx, value);
        modify(2*node+1, mid+1, end, idx, value);

        tree[node] = tree[2*node]+tree[2*node+1];
    }

}
