package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj12919 {
    private static String s, t;
    private static int L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();
        t = br.readLine();
        L = s.length();

        bw.write(solution(t) ? "1" : "0");

        bw.flush();
        bw.close();
    }

    private static boolean solution(String c) {
        if(c.length() == L) {
            return c.equals(s);
        }

        if(c.charAt(c.length()-1) == 'A') {
            if(solution(c.substring(0, c.length()-1))) {
                return true;
            }
        }

        if(c.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder();
            sb.append(c.substring(1));
            if(solution(sb.reverse().toString())) {
                return true;
            }
        }

        return false;
    }

}
