package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj7578 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int tree[];
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) A[i] = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> B = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) B.put(Integer.parseInt(st.nextToken()), i);

        int h = (int) Math.ceil(Math.log(n)/Math.log(2));
        tree = new int[1<<(h+1)];

        int ret = 0;
        for(int num : A) {
            int sIdx = B.get(num);
            ret += query(1, 0, n-1, sIdx, n-1);
            update(1, 0, n-1, sIdx);
        }

        bw.write(ret+"");
    }

    private static int query(int node, int start, int end, int left, int right) {
        if(right < start || end < left) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return query(2*node, start, mid, left, right)+query(2*node+1, mid+1, end, left, right);
    }

    private static void update(int node, int start, int end, int idx) {
        if(idx < start || end < idx) return;

        if(start == end) {
            tree[node] = 1;
            return;
        }

        int mid = (start+end)/2;

        update(2*node, start, mid, idx);
        update(2*node+1, mid+1, end, idx);

        tree[node] = tree[2*node]+tree[2*node+1];
    }

}
