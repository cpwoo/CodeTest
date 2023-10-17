package CodeTest.Java.programmers.kakao.level2;

public class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String[] arr = nTok(n, k).split("0");
        
        for (String a : arr) {
            if (!a.equals("") && isPrime(Long.parseLong(a))) answer++;
        }
        
        return answer;
    }
    
    private String nTok(int n, int k) {
        String tmp = "";
        while (n != 0) {
            tmp = String.valueOf(n%k) + tmp;
            n /= k;
        }
        return tmp;
    }
    
    private boolean isPrime(long x) {
        if (x <= 1) return false;
        long i = 2;
        while (i*i <= x) {
            if (x%i == 0) return false;
            i++;
        }
        return true;
    }
}
