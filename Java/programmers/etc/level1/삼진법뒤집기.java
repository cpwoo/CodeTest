package CodeTest.Java.programmers.etc.level1;

public class 삼진법뒤집기 {
    public int solution(int n) {
        String a = "";
        while (n>0) {
            a = String.valueOf(n%3)+a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();
        
        return Integer.parseInt(a, 3);
    }
}
