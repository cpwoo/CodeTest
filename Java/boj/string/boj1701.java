package CodeTest.Java.boj.string;

import java.io.*;

public class boj1701 {
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
        String str = br.readLine();
        int ret = 0;
        for(int i=0; i<str.length(); i++) {
            ret = Math.max(ret, makeTable(str.substring(i)));
        }

        bw.write(ret+"");
    }

    private static int makeTable(String pattern) {
        int[] table = new int[pattern.length()];

        for(int i=1, j=0; i<pattern.length(); i++) {
            while(j>0 && pattern.charAt(i) != pattern.charAt(j)) j = table[j-1];

            if(pattern.charAt(i) == pattern.charAt(j)) table[i] = ++j;
        }

        int max = 0;
        for(int i=0; i<pattern.length(); i++) max = Math.max(max, table[i]);

        return max;
    }

}
