package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj3111 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String A = br.readLine();
        String B = new StringBuilder(A).reverse().toString();
        String T = br.readLine();

        int L = A.length();
        Stack<Character> front = new Stack<>();
        Stack<Character> back = new Stack<>();

        int AIdx = 0, BIdx = T.length() - 1;
        boolean flag = true;

        while (AIdx <= BIdx) {
            if (flag) {
                front.add(T.charAt(AIdx));
                AIdx++;
                if (front.size() >= L && match(front, A, L)) {
                    for (int i=0; i<L; i++) front.pop();
                    flag = false;
                }
            } else {
                back.add(T.charAt(BIdx));
                BIdx--;
                if (back.size() >= L && match(back, B, L)) {
                    for (int i=0; i<L; i++) back.pop();
                    flag = true;
                }
            }
        }

        while (!back.isEmpty()) {
            front.add(back.pop());
            if (front.size() >= L && match(front, A, L)) {
                for (int i=0; i<L; i++) front.pop();
            }
        }

        sb = new StringBuilder();
        for (char c : front) sb.append(c);
        bw.write(sb.toString());
    }

    private static boolean match(Stack<Character> stk, String s, int L) {
        for (int i=0; i<L; i++) {
            if (stk.get(stk.size()-L+i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
