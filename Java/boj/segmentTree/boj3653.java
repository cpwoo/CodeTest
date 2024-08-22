package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj3653 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;
    
    private static int tree[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] idx = new int[n+1];
        for(int i=0; i<n+1; i++) idx[i] = n+1-i;

        int h = (int) Math.ceil(Math.log(n+m+1)/Math.log(2));
        tree = new int[1<<(h+1)];

        init(1, n+m, 1);

        int cnt = 1;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            int now = idx[x];
            idx[x] = n+cnt;
            sb.append(query(1, n+m, 1, now+1, n+cnt-1)).append(' ');
            update(1, n+m, 1, now, -1);
            cnt++;
        }
        sb.append('\n');
    }

    private static int init(int start, int end, int node) {
        if(start == end) return tree[node] = 1;

        int mid = (start+end)/2;

        return tree[node] = init(start, mid, 2*node)+init(mid+1, end, 2*node+1);
    }

    private static int query(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return query(start, mid, 2*node, left, right)+query(mid+1, end, 2*node+1, left, right);
    }

    private static void update(int start, int end, int node, int idx, int diff) {
        if(start > idx || end < idx) return;

        tree[node] += diff;

        if(start == end) return;

        int mid = (start+end)/2;

        update(start, mid, 2*node, idx, diff);
        update(mid+1, end, 2*node+1, idx, diff);
    }

}
