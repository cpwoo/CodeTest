package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1201 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

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
        int k = Integer.parseInt(st.nextToken());

        if(n < m+k-1 || n > m*k) {
            bw.write("-1");
            return;
        }

        List<Integer> lst = new ArrayList<>();
        for(int i=k; i>0; i--) lst.add(i);

        n -= k; m--;

        while(m != 0) {
            for(int i=k+n/m; i>k; i--) lst.add(i);
            k += n/m;
            n -= n/m;
            m--;
        }

        sb = new StringBuilder();
        for(Integer i : lst) sb.append(i).append(' ');

        bw.write(sb.toString());
    }

}
