package CodeTest.Java.programmers.etc.level2;

public class 마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
            int remainder = storey%10;
            
            if (remainder > 5) {
                answer += 10-remainder;
                storey += 10;
            } else if (remainder < 5) {
                answer += remainder;
            } else {
                if ((storey/10)%10 > 4) {
                    storey += 10;
                }
                answer += remainder;
            }
            
            storey /= 10;
        }

        return answer;
    }
}
