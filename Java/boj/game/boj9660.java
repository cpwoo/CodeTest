package CodeTest.Java.boj.game;

import java.io.*;

public class boj9660 {
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
        long n = Long.parseLong(br.readLine());
        bw.write((n%7 == 2 || n%7 == 0) ? "CY" : "SK");
    }

}
