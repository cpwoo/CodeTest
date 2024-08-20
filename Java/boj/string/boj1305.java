package CodeTest.Java.boj.string;

import java.io.*;

public class boj1305 {
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
        String str = br.readLine();

        int[] failure = new int[n];
        for(int i=1, j=0; i<n; i++) {
            while(j>0 && str.charAt(i) != str.charAt(j)) j = failure[j-1];

            if(str.charAt(i) == str.charAt(j)) failure[i] = ++j;
        }

        bw.write(n-failure[n-1]+"");
    }

}
