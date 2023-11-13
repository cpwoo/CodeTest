package CodeTest.Java.programmers.etc.level4;

import java.math.BigInteger;

public class 올바른괄호의개수 {
    public BigInteger solution(int n) {
        return new BigInteger("1").multiply(factorial(2*n)).divide(factorial(n).multiply(factorial(n+1)));
    }
    
    private BigInteger factorial(int n) {
        BigInteger num = new BigInteger("1");

        while (n != 1) {
            num = num.multiply(BigInteger.valueOf(n));
            n--;
        }

        return num;
    }
}
