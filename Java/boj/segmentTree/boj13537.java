package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj13537 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;
    
    private static int n, arr[], tree[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) arr[i] = Integer.parseInt(st.nextToken());

        tree = new int[4*n][];

        init(1, 1, n);

        int m = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append(query(1, 1, n, a, b, c)).append('\n');
        }

        bw.write(sb.toString());
    }

    private static void init(int node, int start, int end) {
        if(start == end) {
            tree[node] = new int[1];
            tree[node][0] = arr[start];
            return;
        }
        
        int mid = (start+end)/2;
        
        init(2*node, start, mid);
        init(2*node+1, mid+1, end);

        tree[node] = merge(tree[2*node], tree[2*node+1]);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int sz1 = arr1.length, sz2 = arr2.length;
        int sz = sz1+sz2;

        int[] ret = new int[sz];
        for(int i=0, i1=0, i2=0; i<sz; i++) {
            ret[i] = (i1 < sz1 && (i2 == sz2 || arr1[i1] < arr2[i2])) ? arr1[i1++] : arr2[i2++];
        }

        return ret;
    }

    private static int bisectLeft(int[] arr, int num) {
        int left = 0, right = arr.length;

        while(left < right) {
            int mid = (left+right)/2;
            if(arr[mid] <= num) left = mid+1;
            else right = mid;
        }

        return left;
    }

    private static int query(int node, int start, int end, int left, int right, int num) {
        if(end < left || right < start) return 0;

        if(left <= start && end <= right) return tree[node].length-bisectLeft(tree[node], num);

        int mid = (start+end)/2;

        return query(2*node, start, mid, left, right, num)+query(2*node+1, mid+1, end, left, right, num);
    }

}
