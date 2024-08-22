package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj2357 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int arr[], treeMin[], treeMax[];

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
        treeMax = new int[1<<(h+1)];

        initMin(1, 0, n-1);
        initMax(1, 0, n-1);

        sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(queryMin(1, 0, n-1, a-1, b-1)).append(' ');
            sb.append(queryMax(1, 0, n-1, a-1, b-1)).append('\n');
        }

        bw.write(sb.toString());
    }

    private static int initMin(int node, int start, int end) {
        if(start == end) return treeMin[node] = arr[start];

        int mid = (start+end)/2;

        return treeMin[node] = Math.min(initMin(2*node, start, mid), initMin(2*node+1, mid+1, end));
    }

    private static int initMax(int node, int start, int end) {
        if(start == end) return treeMax[node] = arr[start];

        int mid = (start+end)/2;

        return treeMax[node] = Math.max(initMax(2*node, start, mid), initMax(2*node+1, mid+1, end));
    }

    private static int queryMin(int node, int start, int end, int left, int right) {
        if(start > right || end < left) return 1_000_000_000;

        if(left <= start && end <= right) return treeMin[node];

        int mid = (start+end)/2;

        return Math.min(queryMin(2*node, start, mid, left, right), queryMin(2*node+1, mid+1, end, left, right));
    }

    private static int queryMax(int node, int start, int end, int left, int right) {
        if(start > right || end < left) return 0;

        if(left <= start && end <= right) return treeMax[node];

        int mid = (start+end)/2;

        return Math.max(queryMax(2*node, start, mid, left, right), queryMax(2*node+1, mid+1, end, left, right));
    }

}
