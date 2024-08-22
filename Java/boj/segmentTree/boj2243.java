package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj2243 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int max = 1000000;
    private static int tree[], arr[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        tree = new int[4*max];
        arr = new int[4*max];

        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1) {
                int b = Integer.parseInt(st.nextToken());
                get(1, 1, max, b);
            }
            else if(a == 2) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                init(1, 1, max, b, c);
            }
        }

        bw.write(sb.toString());
    }

    private static int init(int n, int s, int e, int t, int v) {
        if(t < s || e < t) return tree[n];

        if(s == t && t == e) {
            tree[n] += v;
            arr[n] = t;
            return tree[n];
        }

        int m = (s+e)/2;
        
        return tree[n] = init(2*n, s, m, t, v)+init(2*n+1, m+1, e, t, v);
    }

    private static int get(int n, int s, int e, int g) {
        if(s == e) {
            tree[n]--;
            sb.append(arr[n]).append('\n');
            return tree[n];
        }

        int L = tree[2*n];
        int m = (s+e)/2;

        if(L >= g) get(2*n, s, m, g);
        else get(2*n+1, m+1, e, g-L);

        return tree[n] = tree[2*n]+tree[2*n+1];
    }

}
