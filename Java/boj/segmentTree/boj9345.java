package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj9345 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int nums[], tree[][];
    
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
        int k = Integer.parseInt(st.nextToken());

        nums = new int[n+1];
        for(int i=0; i<n+1; i++) nums[i] = i;

        int h = (int) Math.ceil(Math.log(n)/Math.log(2));

        tree = new int[1<<(h+1)+1][2];

        init(1, 1, n);

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken())+1;
            int b = Integer.parseInt(st.nextToken())+1;

            if(q == 0) {
                update(1, 1, n, a, nums[b]);
                update(1, 1, n, b, nums[a]);
                int tmp = nums[a];
                nums[a] = nums[b];
                nums[b] = tmp;
            }
            else {
                sb.append(query(1, 1, n, a, b) ? "YES" : "NO").append('\n');
            }
        }
    }

    private static void init(int node, int start, int end) {
        if(start == end) {
            tree[node][0] = tree[node][1] = nums[start];
            return;
        }

        int mid = (start+end)/2;

        init(2*node, start, mid);
        init(2*node+1, mid+1, end);

        tree[node][0] = tree[2*node][0];
        tree[node][1] = tree[2*node+1][1];
    }

    private static void update(int node, int start, int end, int idx, int val) {
        if(start > idx || end < idx) return;

        if(start == end) {
            tree[node][0] = tree[node][1] = val;
            return;
        }

        int mid = (start+end)/2;

        update(2*node, start, mid, idx, val);
        update(2*node+1, mid+1, end, idx, val);

        tree[node][0] = Math.min(tree[2*node][0], tree[2*node+1][0]);
        tree[node][1] = Math.max(tree[2*node][1], tree[2*node+1][1]);
    }

    private static boolean query(int node, int start, int end, int left, int right) {
        if(left > end || right < start) return true;

        if(left <= start && end <= right) {
            return left <= tree[node][0] && right >= tree[node][1];
        }

        int mid = (start+end)/2;

        return query(2*node, start, mid, left, right) && query(2*node+1, mid+1, end, left, right);
    }

}
