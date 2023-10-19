package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 수식최대화 {
    public long solution(String expression) {
        long answer = Long.MIN_VALUE;
        String[][] op = {{"+","-","*"},{"+","*","-"},{"-","*","+"},
                         {"-","+","*"},{"*","-","+"},{"*","+","-"}};
        List<String> arr = new ArrayList<>();
        
        int start = 0;
        for (int i=0; i<expression.length(); i++) {
            char x = expression.charAt(i);
            if (x == '-' || x == '+' || x == '*') {
                arr.add(expression.substring(start, i));
                arr.add(expression.substring(i, i+1));
                start = i+1;
            }
        }
        arr.add(expression.substring(start));
        
        for (int i=0; i<op.length; i++) {
            List<String> sub = new ArrayList<>(arr);
            for (int j=0; j<3; j++) {
                for (int k=0; k<sub.size(); k++) {
                    if (op[i][j].equals(sub.get(k))) {
                        sub.set(k-1, calc(sub.get(k-1), sub.get(k), sub.get(k+1)));
                        sub.remove(k); 
                        sub.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(sub.get(0))));
        }
        return answer;
    }
    
    private static String calc(String num1, String op, String num2) {
        long n1 = Long.parseLong(num1), n2 = Long.parseLong(num2);
        if (op.equals("+")) return String.valueOf(n1+n2);
        else if (op.equals("-")) return String.valueOf(n1-n2);
        else return String.valueOf(n1*n2);
    }
}
