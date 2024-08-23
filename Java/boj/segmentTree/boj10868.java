package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj10868 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int arr[], treeMin[];

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

        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        int h = (int) Math.ceil(Math.log(n)/Math.log(2));

        treeMin = new int[1<<(h+1)];

        init(1, 0, n-1);

        sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(query(1, 0, n-1, a-1, b-1)).append('\n');
        }

        bw.write(sb.toString());
    }

    private static int init(int node, int start, int end) {
        if(start == end) return treeMin[node] = arr[start];

        int mid = (start+end)/2;

        return treeMin[node] = Math.min(init(2*node, start, mid), init(2*node+1, mid+1, end));
    }

    private static int query(int node, int start, int end, int left, int right) {
        if(start > right || end < left) return 1_000_000_000;

        if(left <= start && end <= right) return treeMin[node];

        int mid = (start+end)/2;

        return Math.min(query(2*node, start, mid, left, right), query(2*node+1, mid+1, end, left, right));
    }

}
