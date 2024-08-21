package CodeTest.Java.boj.string;

import java.io.*;

public class boj13713 {
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
        String inp = br.readLine();

        char[] s = new StringBuilder(inp).reverse().toString().toCharArray();

        int n = s.length;

        int[] z = new int[n];
        z[0] = n;

        for(int i=1, l=-1, r=-1; i<n; i++) {
            if(i <= r) z[i] = Math.min(r-i+1, z[i-l]);

            while(i+z[i] < n && s[z[i]] == s[i+z[i]]) z[i]++;

            if(r < i+z[i]-1) {
                l = i; 
                r = i+z[i]-1;
            }
        }

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) sb.append(z[n-Integer.parseInt(br.readLine())]).append('\n');

        bw.write(sb.toString());
    }

}
