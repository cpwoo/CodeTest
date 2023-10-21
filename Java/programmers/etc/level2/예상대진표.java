package CodeTest.Java.programmers.etc.level2;

public class 예상대진표 {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        while (a != b) {
            answer++;
            a = (a+1)/2; b = (b+1)/2;
        }
        
        return answer;
    }
}
