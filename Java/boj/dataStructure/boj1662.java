package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj1662 {
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
        Stack<Info> stack = new Stack<>(); 
        int length = 0;
        char tmp = '0';

        for(char i: s.toCharArray()) {
            if(i == '(') {
                stack.add(new Info(tmp, length-1));
                length = 0;
            } else if(i == ')') {
                Info info = stack.pop();
                length = ((info.x-'0')*length)+info.len;
            } else {
                length++;
                tmp = i;
            }
        }

        bw.write(length+"");
    }

}

class Info {
    char x;
    int len;

    Info(char x, int len) {
        this.x = x;
        this.len = len;
    }
}
