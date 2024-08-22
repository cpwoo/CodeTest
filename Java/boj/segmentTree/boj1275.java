package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj1275 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static long arr[], tree[];

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
        int q = Integer.parseInt(st.nextToken());

        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Long.parseLong(st.nextToken());

        int h = (int) Math.ceil(Math.log(n)/Math.log(2));
        int tSize = 1<<(h+1);

        tree = new long[tSize];
        init(1, 0, n-1);

        sb = new StringBuilder();

        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append((x <= y) ? query(1, 0, n-1, x-1, y-1) : query(1, 0, n-1, y-1, x-1));
            sb.append('\n');

            long diff = b-arr[a-1];
            arr[a-1] = b;
            
            update(1, 0, n-1, a-1, diff);
        }

        bw.write(sb.toString());
    }

    private static long init(int node, int start, int end) {
        if(start == end) return tree[node] = arr[start];
        
        int mid = (start+end)/2;

        return tree[node] = init(2*node, start, mid)+init(2*node+1, mid+1, end);
    }

    private static long query(int node, int start, int end, int left, int right) {
        if(right < start || end < left) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return query(2*node, start, mid, left, right)+query(2*node+1, mid+1, end, left, right);
    }

    private static void update(int node, int start, int end, int idx, long diff) {
        if(idx < start || end < idx) return;

        tree[node] += diff;

        if(start != end) {
            int mid = (start+end)/2;
            update(2*node, start, mid, idx, diff);
            update(2*node+1, mid+1, end, idx, diff);
        }
    }

}
