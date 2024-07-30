package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj10216 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int n, x[], y[], r[], p[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(t-- > 0) {
            solve();
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        x = new int[n+1];
        y = new int[n+1];
        r = new int[n+1];
        p = new int[n+1];

        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            r[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<n+1; i++) p[i] = i;
        
        sb.append(getArea());
    }

    private static int getArea() {
        int ret = 0;
        for(int i=1; i<n; i++) {
            for(int j=i+1; j<n+1; j++) {
                if((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]) <= (r[i]+r[j])*(r[i]+r[j])) {
                    p[find(i)] = find(j);
                }
            }
        }
        for(int i=1; i<n+1; i++) {
            if(p[i] == i) ret++;
        }
        return ret;
    }

    private static int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

}
