package CodeTest.Java.boj.dataStructure;

import java.io.*;

public class boj16120 {
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
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(char i: s.toCharArray()) {
            sb.append(i);
            if(sb.length() >= 4) {
                if(sb.substring(sb.length()-4).equals("PPAP")) {
                    sb.delete(sb.length()-4, sb.length());
                    sb.append('P');
                }
            }
        }

        if(sb.length() == 1) {
            bw.write((sb.charAt(0) == 'P') ? "PPAP": "NP");
        } else if(sb.length() == 4) {
            bw.write((sb.substring(sb.length()-4).equals("PPAP"))? "PPAP": "NP"); 
        } else {
            bw.write("NP");
        }
    }

}
