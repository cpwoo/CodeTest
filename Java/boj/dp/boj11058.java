package CodeTest.Java.boj.dp;

import java.io.*;

public class boj11058 {
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
        
        long[] data = new long[n+1];
        for(int i=0; i<n+1; i++) data[i] = i;

        for(int i=7; i<n+1; i++) data[i] = Math.max(data[i-3]*2, Math.max(data[i-4]*3, data[i-5]*4));

        bw.write(data[n]+"");
    }

}
