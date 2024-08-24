package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj14428 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;
    
    private static int arr[], tree[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        tree = new int[4*n][];

        init(1, 0, n-1);

        int m = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1) update(1, 0, n-1, b-1, c);
            else {
                int[] ret = query(1, 0, n-1, b-1, c-1);
                sb.append(ret[0]).append('\n');
            }
        }
        
        bw.write(sb.toString());
    }

    private static int[] init(int node, int start, int end) {
        if(start == end) return tree[node] = new int[]{start+1, arr[start]};

        int mid = (start+end)/2;
        int[] p = init(2*node, start, mid);
        int[] q = init(2*node+1, mid+1, end);

        return tree[node] = (p[1] <= q[1]) ? p : q;
    }

    private static int[] update(int node, int start, int end, int idx, int x) {
        if(idx < start || idx > end) return tree[node];

        if(start == end) return tree[node] = new int[]{idx+1, x};

        int mid = (start+end)/2;

        int[] p = update(2*node, start, mid, idx, x);
        int[] q = update(2*node+1, mid+1, end, idx, x);

        return tree[node] = (p[1] <= q[1]) ? p : q;
    }

    private static int[] query(int node, int start, int end, int left, int right) {
        if(start > right || end < left) return new int[]{1, Integer.MAX_VALUE};

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        int[] p = query(2*node, start, mid, left, right);
        int[] q = query(2*node+1, mid+1, end, left, right);

        return (p[1] <= q[1]) ? p : q;
    }

}
