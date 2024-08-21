package CodeTest.Java.boj.string;

import java.io.*;

public class boj14444 {
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
        char[] arr = br.readLine().toCharArray();

        sb = new StringBuilder();
        sb.append('#');
        for(char a : arr) sb.append(a).append('#');

        String str = sb.toString();

        int n = str.length();
        int[] a = new int[n];

        for(int i=0, c=0, r=0; i<n; i++) {
            a[i] = (r < i) ? 0 : Math.min(a[(2*c)-i], r-i);

            while(i-(a[i]+1) >= 0 && i+(a[i]+1) < n && str.charAt(i-(a[i]+1)) == str.charAt(i+(a[i]+1))) a[i]++;

            if(r < i+a[i]) {
                r = i+a[i];
                c = i;
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) max = Math.max(max, a[i]);

        bw.write(max+"");
    }

}
