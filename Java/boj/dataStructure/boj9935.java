package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj9935 {
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
        String p = br.readLine();

        int len = p.length();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            stack.add(s.charAt(i));

            if(stack.size() >= len) {
                boolean flag = true;
                for(int j=0; j<len; j++) {
                    if(stack.get(stack.size()-len+j) != p.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j=0; j<len; j++) stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c: stack) {
            sb.append(c);
        }

        bw.write((sb.length() == 0) ? "FRULA": sb.toString());
    }

}
