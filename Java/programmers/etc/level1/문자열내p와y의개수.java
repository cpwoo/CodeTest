package CodeTest.Java.programmers.etc.level1;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        String[] str = s.toLowerCase().split("");
        int p = 0, y = 0;

        for (int i=0; i<str.length; i++) {
            if (str[i].equals("p")) p++;
            else if (str[i].equals("y")) y++;
        }
         
        return p == y;
    }
}
