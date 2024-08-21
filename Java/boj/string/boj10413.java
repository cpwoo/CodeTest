package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj10413 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static int t;

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
        String str = br.readLine();
        int n = str.length();

        Integer[] suffix = new Integer[n];
        for(int i=0; i<n; i++) suffix[i] = i;

        int[] g = new int[n+1];
        for(int i=0; i<n; i++) g[i] = str.charAt(i);
        g[n] = -1;

        int[] ng = new int[n+1];
        ng[suffix[0]] = 0; ng[n] = -1;

        t = 1;
        while(t < n) {
            Arrays.sort(suffix, new Comparator<Integer>() {
			    public int compare(Integer o1, Integer o2) {
				    if(g[o1] != g[o2]) return g[o1]-g[o2];
				    return g[Math.min(o1+t, n)]-g[Math.min(o2+t, n)];
			    }
            });

            for(int i=1; i<n; i++) {
                int p = suffix[i-1], q = suffix[i];

                if(g[p] != g[q] || g[Math.min(p+t, n)] != g[Math.min(q+t, n)]) {
                    ng[q] = ng[p]+1;
                }
                else ng[q] = ng[p];
            }

            if(ng[n-1] == n-1) break;

            t <<= 1;
            for(int i=0; i<n+1; i++) g[i] = ng[i];
        }

        int[] r = new int[n];
        for(int i=0; i<n; i++) r[suffix[i]] = i;

        int[] LCP = new int[n];
        int L = 0;
        for(int i=0; i<n; i++) {
            int k = r[i];
            if(k == 0) continue;
            
            int p = suffix[k-1];

            while(i+L < n && p+L < n && str.charAt(i+L) == str.charAt(p+L)) L++;

            LCP[k] = L;

            if(L != 0) L--;
        }

        int ret = 0;
        for(int i=1; i<n; i++) ret += Math.max(0, LCP[i]-LCP[i-1]);

        sb.append(ret).append('\n');
    }

}