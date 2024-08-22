package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj1395 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int tree[], lazy[];

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

        int h = (int) Math.ceil(Math.log(N)/Math.log(2));
        int length = (N&(N-1)) == 0 ? N<<1 : 1<<(h+1);
        
        tree = new int[length];
        lazy = new int[length];

        sb = new StringBuilder();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if(o == 0) {
                update(1, 1, N, s, t);
            }
            else {
                sb.append(query(1, 1, N, s, t)).append('\n');
            }
        }

        bw.write(sb.toString());
    }

    private static void update(int node, int start, int end, int left, int right) {
        propagate(node, start, end);

        if(right < start || end < left) return;

        if(left <= start && end <= right) {
            tree[node] = (end-start+1)-tree[node];

            if(start != end) {
                lazy[2*node] ^= 1;
                lazy[2*node+1] ^= 1;
            }

            return;
        }

        int mid = (start+end)/2;
        update(2*node, start, mid, left, right);
        update(2*node+1, mid+1, end, left, right);

        tree[node] = tree[2*node]+tree[2*node+1];
    }

    private static int query(int node, int start, int end, int left, int right) {
        propagate(node, start, end);

        if(right < start || end < left) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return query(2*node, start, mid, left, right)+query(2*node+1, mid+1, end, left, right);
    }

    private static void propagate(int node, int start, int end) {
        if(lazy[node] != 0) {
            tree[node] = (end-start+1)-tree[node];

            if(start != end) {
                lazy[2*node] ^= 1;
                lazy[2*node+1] ^= 1;
            }

            lazy[node] = 0;
        }
    }

}
