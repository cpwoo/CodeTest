package CodeTest.Java.boj.divideNconquer;

import java.io.*;
import java.util.*;

public class boj4256 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int preorder[], inorder[], idx;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            solve();
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        preorder = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) preorder[i] = Integer.parseInt(st.nextToken());

        inorder = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) inorder[i] = Integer.parseInt(st.nextToken());

        idx = 0;
        postorder(0, n-1);

        sb.append('\n');
    }

    private static void postorder(int start, int end) {
        int mid = start;

        while(preorder[idx] != inorder[mid]) mid++;

        if(start <= mid-1) {
            idx++;
            postorder(start, mid-1);
        }

        if(mid+1 <= end) {
            idx++;
            postorder(mid+1, end);
        }

        sb.append(inorder[mid]).append(' ');
    }

}
