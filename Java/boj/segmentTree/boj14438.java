package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj14438 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;
    
    private static int arr[], tree[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) arr[i] = Integer.parseInt(st.nextToken());

        tree = new int[270000];

        init(1, 1, n);

        int m = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1) update(1, 1, n, b, c);
            else {
                sb.append(query(1, 1, n, b, c)).append('\n');
            }
        }
        
        bw.write(sb.toString());
    }

    private static void init(int node, int start, int end) {
        if(start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start+end)/2;
        init(2*node, start, mid);
        init(2*node+1, mid+1, end);

        tree[node] = Math.min(tree[2*node], tree[2*node+1]);
    }

    private static void update(int node, int start, int end, int idx, int x) {
        if(idx < start || idx > end) return;

        if(start == end) {
            tree[node] = arr[start] = x;
            return;
        }

        int mid = (start+end)/2;

        update(2*node, start, mid, idx, x);
        update(2*node+1, mid+1, end, idx, x);

        tree[node] = Math.min(tree[2*node], tree[2*node+1]);
    }

    private static int query(int node, int start, int end, int left, int right) {
        if(left > end || right < start) return Integer.MAX_VALUE;

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return Math.min(query(2*node, start, mid, left, right), query(2*node+1, mid+1, end, left, right));
    }

}
