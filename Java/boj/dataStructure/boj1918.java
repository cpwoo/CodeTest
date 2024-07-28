package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj1918 {
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
        String strs = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder stb = new StringBuilder();

        for(char s: strs.toCharArray()) {
            if(('a' <= s && s <= 'z') || ('A' <= s && s <= 'Z')) {
                stb.append(s);
            } else {
                if(s == '(') stack.add(s);
                else if(s == '*' || s == '/') {
                    while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        stb.append(stack.pop());
                    }
                    stack.add(s);
                }
                else if(s == '+' || s == '-') {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        stb.append(stack.pop());
                    }
                    stack.add(s);
                }
                else if(s == ')') {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        stb.append(stack.pop());
                    }
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()) stb.append(stack.pop());

        bw.write(stb.toString());
    }

}
