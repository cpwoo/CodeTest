package CodeTest.Java.programmers.etc.level2;

public class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i=0; i<numbers.length; i++) {
            long number = numbers[i];
            long zero = 1, one = 0;
            
            while (number > 0) {
                if (number%2 == 0) break;
                else {
                    zero *= 2;
                    if (one == 0) one = 1;
                    else one *= 2;
                    number /= 2;
                }
            }
            
            answer[i] = numbers[i]+zero-one;
        }
        
        return answer;
    }
}
