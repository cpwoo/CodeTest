package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj12837 {
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
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int h = (int) Math.ceil(Math.log(N)/Math.log(2));

        tree = new long[1<<(h+1)];

        sb = new StringBuilder();

        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if(cmd == 1) update(1, 0, N-1, p-1, q);
            else sb.append(query(1, 0, N-1, p-1, q-1)).append('\n');
        }

        bw.write(sb.toString());
    }

    private static void update(int node, int start, int end, int p, int q) {
        if(start <= p && p <= end) {
            tree[node] += q;
            if(start != end) {
                int mid = (start+end)/2;
                update(2*node, start, mid, p, q);
                update(2*node+1, mid+1, end, p, q);
            }
        }
    }

    private static long query(int node, int start, int end, int p, int q) {
        if(q < start || end < p) return 0;

        if(p <= start && end <= q) return tree[node];

        int mid = (start+end)/2;

        return query(2*node, start, mid, p, q)+query(2*node+1, mid+1, end, p, q);
    }

}
