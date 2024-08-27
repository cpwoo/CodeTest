package CodeTest.Java.boj.greedy;

import java.io.*;

public class boj12904 {
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
        String p = br.readLine();
        StringBuilder q = new StringBuilder(br.readLine());

        boolean flag = false;
        while(q.length() != 0) {
            if(q.charAt(q.length()-1) == 'A') q.deleteCharAt(q.length()-1);
            else {
                q.deleteCharAt(q.length()-1);
                q.reverse();
            }
            if(p.equals(q.toString())) {
                flag = true;
                break;
            }
        }

        bw.write((flag) ? "1" : "0");
    }
}
