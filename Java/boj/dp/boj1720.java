package CodeTest.Java.boj.dp;

import java.io.*;

public class boj1720 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        long[] d = new long[31];
        long[] s = new long[31];
        
        d[1] = 1; d[2] = 3;
        s[1] = 1; s[2] = 3; s[3] = 1; s[4] = 5;

        for(int i=3; i<n+1; i++) d[i] = 2*d[i-2]+d[i-1];
        for(int i=5; i<n+1; i++) s[i] = 2*s[i-4]+s[i-2];

        bw.write((d[n]-s[n])/2+s[n]+"");
    }

}
