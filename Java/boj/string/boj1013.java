package CodeTest.Java.boj.string;

import java.io.*;
import java.util.regex.*;

public class boj1013 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String str = br.readLine();
        Pattern pattern = Pattern.compile("(100+1+|01)+");
        sb.append((pattern.matcher(str).matches()) ? "YES\n" : "NO\n");
    }

}
