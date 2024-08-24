package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj12844 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int arr[], tree[], lazy[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int h = (int) Math.ceil(Math.log(N)/Math.log(2));

        tree = new int[1<<(h+1)];
        lazy = new int[1<<(h+1)];

        init(1, 0, N-1);

        int Q = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                int r = Integer.parseInt(st.nextToken());
                update(1, 0, N-1, r, p, q);
            }
            else sb.append(query(1, 0, N-1, p, q)).append('\n');
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

        tree[node] = tree[2*node]^tree[2*node+1];
    }

    private static void update(int node, int start, int end, int val, int left, int right) {
        propagate(node, start, end);

        if(right < start || end < left) return;

        if(left <= start && end <= right) {
            lazy[node] ^= val;
            propagate(node, start, end);
            return;
        }

        int mid = (start+end)/2;

        update(2*node, start, mid, val, left, right);
        update(2*node+1, mid+1, end, val, left, right);

        tree[node] = tree[2*node]^tree[2*node+1];
    }

    private static int query(int node, int start, int end, int left, int right) {
        propagate(node, start, end);

        if(right < start || end < left) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return query(2*node, start, mid, left, right)^query(2*node+1, mid+1, end, left, right);
    }

    private static void propagate(int node, int start, int end) {
        if(lazy[node] != 0) {
            if((end-start+1)%2 == 1) tree[node] ^= lazy[node];

            if(start != end) {
                lazy[2*node] ^= lazy[node];
                lazy[2*node+1] ^= lazy[node];
            }

            lazy[node] = 0;
        }
    }

}
