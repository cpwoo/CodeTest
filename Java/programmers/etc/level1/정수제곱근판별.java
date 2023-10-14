package CodeTest.Java.programmers.etc.level1;

public class 정수제곱근판별 {
    public long solution(long n) {
        double i = Math.sqrt(n);
        return Math.floor(i) == i ? (long) Math.pow(i+1, 2) : -1;
    }
}
