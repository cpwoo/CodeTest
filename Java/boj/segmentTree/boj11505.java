package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj11505 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int mod = 1_000_000_007;

    private static int nums[];
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        nums = new int[N];
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(br.readLine());

        tree = new long[4*N];

        init(1, 0, N-1);

        sb = new StringBuilder();

        for(int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1) {
                update(1, 0, N-1, b-1, c);
            }
            else {
                sb.append(summit(1, 0, N-1, b-1, c-1)).append('\n');
            }
        }

        bw.write(sb.toString());
    }

    private static long init(int node, int start, int end) {
        if(start == end) return tree[node] = nums[start];

        int mid = (start+end)/2;

        return tree[node] = mod(init(2*node, start, mid)*init(2*node+1, mid+1, end));
    }

    private static void update(int node, int start, int end, int idx, int diff) {
        if(idx < start || end < idx) return;

        if(start == end) tree[node] = diff;
        else {
            int mid = (start+end)/2;
            update(2*node, start, mid, idx, diff);
            update(2*node+1, mid+1, end, idx, diff);
            tree[node] = mod(tree[2*node]*tree[2*node+1]);
        }
    }

    private static long summit(int node, int start, int end, int left, int right) {
        if(right < start || end < left) return 1;

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;
        
        return mod(summit(2*node, start, mid, left, right)*summit(2*node+1, mid+1, end, left, right));
    }

    private static long mod(long num) {
        long ret = num%mod;
        return (ret >= 0) ? ret : ret+mod;
    }

}
