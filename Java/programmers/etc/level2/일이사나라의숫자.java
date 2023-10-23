package CodeTest.Java.programmers.etc.level2;

public class 일이사나라의숫자 {
    public String solution(int n) {
        String answer = "";
        
        while (n != 0) {
            if (n%3 != 0) {
                answer = String.valueOf(n%3)+answer;
                n = n/3;
            } else {
                answer = "4"+answer;
                n = n/3-1;
            }
        }

        return answer;
    }
}
