package CodeTest.Java.programmers.etc.level1;

public class 수박수박수박수박수박수 {
    public String solution(int n) {
        String answer = "";
        for (int i=0; i<n/2; i++) {
            answer += "수박";
        }
        return n%2 == 0 ? answer : answer+"수";
    }
}
