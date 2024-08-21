package CodeTest.Java.boj.string;

import java.io.*;

public class boj4354 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;
            solve(str);
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve(String str) throws Exception {
        int L = str.length();

        int[] tmp = new int[L];

        for(int i=1, j=0; i<L; i++) {
            while(j > 0 && str.charAt(i) != str.charAt(j)) j = tmp[j-1];

            if(str.charAt(i) == str.charAt(j)) tmp[i] = ++j;
        }

        int div = L-tmp[L-1];

        sb.append((L%div != 0) ? "1\n" : L/div+"\n");
    }
}
