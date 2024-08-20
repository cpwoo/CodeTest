package CodeTest.Java.boj.string;

import java.io.*;

public class boj1786 {
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
        String parent = br.readLine(), pattern = br.readLine();
        int n = parent.length(), m = pattern.length();

        int[] table = new int[m];
        for(int i=1, j=0; i<m; i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = table[j-1];

            if(pattern.charAt(i) == pattern.charAt(j)) table[i] = ++j;
        }

        int cnt = 0;
        sb = new StringBuilder();
        for(int i=0, j=0; i<n; i++) {
            while(j > 0 && parent.charAt(i) != pattern.charAt(j)) j = table[j-1];

            if(parent.charAt(i) == pattern.charAt(j)) {
                if(j == m-1) {
                    cnt++;
                    sb.append(i-m+2).append(' ');
                    j = table[j];
                }
                else j++;
            }
        }

        bw.write(cnt+"\n");
        bw.write(sb.toString());
    }

}
