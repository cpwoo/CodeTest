package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj10999 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static long nums[], tree[], lazy[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        nums = new long[N+1];
        for(int i=1; i<N+1; i++) nums[i] = Long.parseLong(br.readLine());

        int h = (int) Math.ceil(Math.log(N)/Math.log(2));
        int length = 1<<(h+1);
        
        tree = new long[length];
        lazy = new long[length];

        init(1, 1, N);

        sb = new StringBuilder();

        for(int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                long d = Long.parseLong(st.nextToken());
                update(1, 1, N, b, c, d);
            }
            else {
                sb.append(query(1, 1, N, b, c)).append('\n');
            }
        }

        bw.write(sb.toString());
    }

    private static void init(int node, int start, int end) {
        if(start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = (start+end)/2;

        init(2*node, start, mid);
        init(2*node+1, mid+1, end);

        tree[node] = tree[2*node]+tree[2*node+1];
    }

    private static void update(int node, int start, int end, long left, long right, long value) {
        propagate(node, start, end);

        if(right < start || end < left) return;

        if(left <= start && end <= right) {
            tree[node] += (end-start+1)*value;

            if(start != end) {
                lazy[2*node] += value;
                lazy[2*node+1] += value;
            }

            return;
        }

        int mid = (start+end)/2;
        update(2*node, start, mid, left, right, value);
        update(2*node+1, mid+1, end, left, right, value);

        tree[node] = tree[2*node]+tree[2*node+1];
    }

    private static long query(int node, int start, int end, long left, long right) {
        propagate(node, start, end);

        if(right < start || end < left) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return query(2*node, start, mid, left, right)+query(2*node+1, mid+1, end, left, right);
    }

    private static void propagate(int node, int start, int end) {
        if(lazy[node] != 0) {
            tree[node] += (end-start+1)*lazy[node];

            if(start != end) {
                lazy[2*node] += lazy[node];
                lazy[2*node+1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

}
