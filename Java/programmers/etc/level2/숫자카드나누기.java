package CodeTest.Java.programmers.etc.level2;

public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int[] answer = new int[2];
        
        int gcdA = arrayA[0];
        for (int i=1; i<arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for (int i=1; i<arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        boolean flagA = true;
        for (int A : arrayA) {
            if (A%gcdB == 0) {
                flagA = false;
                break;
            }
        }
        
        boolean flagB = true;
        for (int B : arrayB) {
            if (B%gcdA == 0) {
                flagB = false;
                break;
            }
        }
        
        if (flagA) answer[0] = gcdB;
        if (flagB) answer[1] = gcdA;
        
        return Math.max(answer[0], answer[1]);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}
