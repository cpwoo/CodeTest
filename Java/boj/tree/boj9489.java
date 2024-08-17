package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj9489 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(n == 0 && k == 0) break;
            solve(n, k);
        }
        
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve(int n, int k) throws Exception {
        int[] arr = new int[n+1];
        arr[0] = -1;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] p = new int[n+1];
        p[0] = -1;

        int target = 0, idx = -1;

        for(int i=1; i<n+1; i++) {
            if(arr[i] == k) target = i;
            if(arr[i] != arr[i-1]+1) idx++;
            p[i] = idx;
        }

        int ret = 0;
        for(int i=1; i<n+1; i++) {
            if(p[i] != p[target] && p[p[i]] == p[p[target]]) ret++;
        }

        sb.append(ret).append('\n');
    }

}
