package CodeTest.Java.boj.divideNconquer;

import java.io.*;
import java.util.*;

public class boj1517 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, arr[];
    private static long cnt;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        cnt = 0;
        sort(0, n-1);
        bw.write(cnt+"");
    }

    private static void sort(int start, int end) {
        if(start < end) {
            int mid = (start+end)/2;
            sort(start, mid);
            sort(mid+1, end);
            merge(start, mid, end);
        }
    }

    private static void merge(int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(arr, start, mid+1);
        int[] right = Arrays.copyOfRange(arr, mid+1, end+1);

        int idx = start, leftIdx = 0, rightIdx = 0, len = left.length;

        while(leftIdx < left.length && rightIdx < right.length) {
            if(left[leftIdx] > right[rightIdx]) {
                arr[idx] = right[rightIdx++];
                cnt += len;
            } else {
                arr[idx] = left[leftIdx++];
                len--;
            }
            idx++;
        }

        while(rightIdx < right.length) arr[idx++] = right[rightIdx++];
        while(leftIdx < left.length) arr[idx++] = left[leftIdx++];
    }

}
