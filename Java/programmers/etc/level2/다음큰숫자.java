package CodeTest.Java.programmers.etc.level2;

public class 다음큰숫자 {
    public int solution(int n) {
        int answer = n+1;
        int cnt = 0;
        for (char i : Integer.toBinaryString(n).toCharArray()) {
            if (i == '1') cnt++;
        }

        while (true) {
            int tmp = 0;
            for (char i : Integer.toBinaryString(answer).toCharArray()) {
                if (i == '1') tmp++;
            }
            if (cnt == tmp) break;
            answer++;
        }

        return answer;
    }
}
