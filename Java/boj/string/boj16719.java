package CodeTest.Java.boj.string;

import java.io.*;

public class boj16719 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static String str;
    private static boolean v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        str = br.readLine();
        v = new boolean[str.length()];

        sb = new StringBuilder();
        zoac(0, str.length()-1);

        bw.write(sb.toString());
    }

    private static void zoac(int left, int right) {
        if(left > right) return;

        int idx = left;

        for(int i=left; i<right+1; i++) {
            if(str.charAt(idx) > str.charAt(i)) idx = i;
        }
        
        v[idx] = true;

        for(int i=0; i<str.length(); i++) {
            if(v[i]) sb.append(str.charAt(i));
        }

        sb.append('\n');

        zoac(idx+1, right);
        zoac(left, idx-1);
    }

}
