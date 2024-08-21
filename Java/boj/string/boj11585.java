package CodeTest.Java.boj.string;

import java.io.*;

public class boj11585 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        char[] p = br.readLine().toCharArray();
        br.readLine().toCharArray();

        int[] pi = new int[n];

        int j=0;
        for(int i=1; i<n; i++) {
            while(j > 0 && p[i<<1] != p[j<<1]) j = pi[j-1];
            if(p[i<<1] == p[j<<1]) pi[i] = ++j;
            else j = 0;
        }

        int t = n-j;
        
        sb = new StringBuilder();
        if(t != 0 && n%t == 0) sb.append(1).append('/').append(t);
        else sb.append(1).append('/').append(n);

        bw.write(sb.toString());
    }

}
