package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj2042 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static long nList[], tree[];

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
        int k = Integer.parseInt(st.nextToken());

        nList = new long[n];
        for(int i=0; i<n; i++) nList[i] = Long.parseLong(br.readLine());

        tree = new long[4*n];
        init(0, n-1, 1);

        sb = new StringBuilder();

        for(int i=0; i<m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                b--;
                long diff = c-nList[b];
                nList[b] = c;
                update(0, n-1, 1, b, diff);
            }
            else if(a == 2) {
                sb.append(summit(0, n-1, 1, b-1, (int)c-1)).append('\n');
            }
        }

        bw.write(sb.toString());
    }

    private static long init(int start, int end, int node) {
        if(start == end) return tree[node] = nList[start];

        int mid = (start+end)/2;

        return tree[node] = init(start, mid, 2*node)+init(mid+1, end, 2*node+1);
    }

    private static void update(int start, int end, int node, int idx, long diff) {
        if(idx < start || idx > end) return;

        tree[node] += diff;

        if(start == end) return;

        int mid = (start+end)/2;
        update(start, mid, 2*node, idx, diff);
        update(mid+1, end, 2*node+1, idx, diff);
    }

    private static long summit(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return summit(start, mid, 2*node, left, right)+summit(mid+1, end, 2*node+1, left, right);
    }

}
