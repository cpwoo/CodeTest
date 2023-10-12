package CodeTest.Java.programmers.etc.level1;

public class 기사단원의무기 {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        
        for (int i=2; i<=number; i++) {
            int cnt = 0;
            for (int j=1; j<=Math.sqrt(i); j++) {
                if (i%j == 0) {
                    cnt++;
                    if (j*j != i) {
                        cnt++;
                    }
                }
            }
            if (cnt > limit) cnt = power;
            answer += cnt;
        }
        
        return answer;
    }
}
