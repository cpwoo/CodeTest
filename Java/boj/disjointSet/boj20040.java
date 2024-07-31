package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj20040 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int p[], endGame;

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

        p = new int[n];
        for(int i=0; i<n; i++) p[i] = i;

        endGame = 0;
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b, i+1);
        }

        bw.write(endGame+"");
    }

    private static int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private static void union(int a, int b, int idx) {
        a = find(a); b = find(b);
        if(a != b) {
            p[Math.max(a,b)] = Math.min(a,b);
        } else if(endGame == 0) {
            endGame = idx;
        }
    }

}
