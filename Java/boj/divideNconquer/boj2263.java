package CodeTest.Java.boj.divideNconquer;

import java.io.*;
import java.util.*;

public class boj2263 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int inorder[], postorder[], inorderIndices[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) inorder[i] = Integer.parseInt(st.nextToken());
        
        postorder = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) postorder[i] = Integer.parseInt(st.nextToken());

        inorderIndices = new int[n+1];
        Arrays.fill(inorderIndices, -1);
        for(int i=0; i<n; i++) inorderIndices[inorder[i]] = i;

        sb = new StringBuilder();
        preorder(0, n-1, 0, n-1);

        bw.write(sb.toString());
    }
    
    private static void preorder(int istart, int iend, int pstart, int pend) {
        if(istart > iend || pstart > pend) return;

        int root = postorder[pend];
        sb.append(root).append(" ");

        int leftCnt = inorderIndices[root]-istart;
        int rightCnt = iend-inorderIndices[root];

        preorder(istart, inorderIndices[root]-1, pstart, pstart+leftCnt-1);
        preorder(inorderIndices[root]+1, iend, pend-rightCnt, pend-1);
    }

}
