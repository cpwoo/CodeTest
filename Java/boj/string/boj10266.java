package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj10266 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int sz = 360000;
    private static int[] v, w;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        v = new int[2*sz]; w = new int[sz];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) v[Integer.parseInt(st.nextToken())] = 1;
        for(int i=0; i<sz; i++) v[i+sz] = v[i];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) w[Integer.parseInt(st.nextToken())] = 1;

        bw.write((kmp()) ? "possible" : "impossible");
    }

    private static boolean kmp() {
        int[] f = new int[sz];
        for(int i=1, j=0; i<sz; i++) {
            while(j > 0 && w[i] != w[j]) j = f[j-1];
            
            if(w[i] == w[j]) f[i] = ++j;
        }

        for(int i=1, j=0; i<2*sz; i++) {
            while(j > 0 && v[i] != w[j]) j = f[j-1];

            if(v[i] == w[j]) {
                if(j == sz-1) return true;
                j++;
            }
        }

        return false;
    }
}
