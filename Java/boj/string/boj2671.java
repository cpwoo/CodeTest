package CodeTest.Java.boj.string;

import java.io.*;
import java.util.regex.*;

public class boj2671 {
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
        Pattern pattern = Pattern.compile("(100+1+|01)+");
        bw.write((pattern.matcher(str).matches()) ? "SUBMARINE" : "NOISE");
    }

}
