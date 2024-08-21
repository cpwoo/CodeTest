package CodeTest.Java.boj.string;

import java.io.*;

public class boj16163 {
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

        long ret = 0;
        for(int i=0, c=0, r=0; i<n; i++) {
            if(str.charAt(i) != '#') ret++;

            if(r < i) a[i] = 0;
            else {
                a[i] = Math.min(a[(2*c)-i], r-i);
                ret += a[i]/2;
            }

            while(i-(a[i]+1) >= 0 && i+(a[i]+1) < n && str.charAt(i-(a[i]+1)) == str.charAt(i+(a[i]+1))) {
                a[i]++;
                if(str.charAt(i+a[i]) != '#') ret++;
            }

            if(r < i+a[i]) {
                r = i+a[i];
                c = i;
            }
        }

        bw.write(ret+"");
    }

}
