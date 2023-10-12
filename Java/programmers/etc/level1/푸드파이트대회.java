package CodeTest.Java.programmers.etc.level1;

public class 푸드파이트대회 {
    public String solution(int[] food) {
        String answer = "0";
        
        for (int i=food.length-1; i>=0; i--) {
            for (int j=0; j<food[i]/2; j++) {
                answer = i+answer+i;
            }
        }
        return answer;
    }
}
