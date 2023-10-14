package CodeTest.Java.programmers.etc.level1;

public class 최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        return new int[]{gcd(n,m), n*m/gcd(n,m)};
    }
    
    private int gcd(int n, int m) {
        while (m != 0) {
            int tmp = n;
            n = m;
            m = tmp%m;
        }
        return n;
    }
}
