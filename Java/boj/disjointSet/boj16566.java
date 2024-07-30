package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj16566 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int m, my[], p[];

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
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        my = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) my[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(my);

        p = new int[m+1];
        for(int i=0; i<m+1; i++) p[i] = i;
        
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        for(int i=0; i<k; i++) {
            int num = Integer.parseInt(st.nextToken());

            int idx = upperBound(num);
            int choiceIdx = find(idx);
            
            sb.append(my[choiceIdx]).append("\n");
            union(choiceIdx, choiceIdx+1);
        }

        bw.write(sb.toString());
    }

    private static int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private static void union(int a, int b) {
        a = find(a); b = find(b);
        p[a] = b;
    }

    private static int upperBound(int key) {
        int s = 0, e = m-1;
        while(s <= e) {
            int mid = (s+e)/2;
            if(my[mid] <= key) s = mid+1;
            else e = mid-1;
        }
        return s;
    }

}
