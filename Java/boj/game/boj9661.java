package CodeTest.Java.boj.game;

import java.io.*;

public class boj9661 {
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
        bw.write((n%5 == 2 || n%5 == 0) ? "CY" : "SK");
    }

}
