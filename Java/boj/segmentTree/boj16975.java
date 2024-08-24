package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj16975 {
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
        int n = Integer.parseInt(br.readLine());

        int h = (int) Math.ceil(Math.log(n)/Math.log(2));
        int sz = 1<<h;
        
        tree = new long[2*sz];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) tree[sz+i] = Long.parseLong(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                update(1, 1, sz, b, c, d);
            }
            else {
                int b = Integer.parseInt(st.nextToken());
                sb.append(query(sz+b-1)).append('\n');
            }
        }
        
        bw.write(sb.toString());
    }

    private static void update(int node, int start, int end, int left, int right, int diff) {
        if(right < start || end < left) return;

        if(left <= start && end <= right) {
            tree[node] += diff;
            return;
        }

        int mid = (start+end)/2;

        update(2*node, start, mid, left, right, diff);
        update(2*node+1, mid+1, end, left, right, diff);
    }

    private static long query(int node) {
        long ret = 0;
        while(node >= 1) {
            ret += tree[node];
            node /= 2;
        }
        return ret;
    }

}
