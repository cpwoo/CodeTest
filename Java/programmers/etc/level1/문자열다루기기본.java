package CodeTest.Java.programmers.etc.level1;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        int n = s.length();
        return (n==4 || n==6) && s.matches("(^[0-9]*$)");
    }
}
