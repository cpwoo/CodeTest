package CodeTest.Java.programmers.etc.level2;

public class N개의최소공배수 {
    public int solution(int[] arr) {
        int answer = 1;
        for (int a : arr) {
            answer = (answer*a)/gcd(answer,a);
        }
        return answer;
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a; a = b; b = tmp%b;
        }
        return a;
    }
}
