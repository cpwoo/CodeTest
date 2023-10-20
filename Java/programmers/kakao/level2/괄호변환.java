package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 괄호변환 {
    public String solution(String p) {
        if (p.equals("")) return p;

        String[] str = split(p);
        String u = str[0], v = str[1];

        if (check(u)) {
            u += solution(v);
            return u;
        } else {
            return "(" + solution(v) + ")" + flip(u.substring(1, u.length()-1));
        }
    }

    private static String[] split(String p) {
        String u = "", v = p;
        int[] d = new int[2];
        int idx = 0;
        for (char i : p.toCharArray()) {
            u += i;
            idx++;
            
            if (i == '(') d[0]++;
            else d[1]++;

            if (d[0] == d[1]) break;

        }
        return new String[]{u, v.substring(idx)};
    }

    private static boolean check(String u) {
        Stack<Character> stk = new Stack<>();
        for (char i : u.toCharArray()) {
            if (i == '(') stk.push(i);
            else {
                if (!stk.isEmpty() && stk.peek() == '(') stk.pop();
                else stk.add(i);
            }
        }

        return stk.isEmpty();
    }

    private static String flip(String u) {
        String ret = "";
        for (char i : u.toCharArray()) {
            if (i == '(') ret += ')';
            else if (i == ')') ret += '(';
        }
        return ret;
    }
}
