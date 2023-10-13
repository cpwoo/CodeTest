package CodeTest.Java.programmers.etc.level1;

public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int num : numbers) {
            answer -= num;
        }
        return answer;
    }
}
