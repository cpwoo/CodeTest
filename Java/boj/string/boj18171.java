package CodeTest.Java.boj.string;

import java.io.*;

public class boj18171 {
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
        char[] arr = br.readLine().toCharArray();

        sb = new StringBuilder();
        sb.append('#');
        for(char a : arr) sb.append(a).append('#');

        String str = sb.toString();
        int L = str.length();

        int[] a = new int[L];

        for(int i=0, c=0, r=0; i<L; i++) {
            a[i] = (r < i) ? 0 : Math.min(a[(2*c)-i], r-i);

            while(i-(a[i]+1) >= 0 && i+(a[i]+1) < L && str.charAt(i-(a[i]+1)) == str.charAt(i+(a[i]+1))) a[i]++;

            if(r < i+a[i]) {
                r = i+a[i];
                c = i;
            }
        }

        int rad = 0;
        for(int i=0; i<L; i++) {
            if(i+a[i] == 2*n) rad = Math.max(rad, a[i]);
        }

        bw.write(n-rad+"");
    }

}
