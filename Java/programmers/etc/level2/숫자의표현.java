package CodeTest.Java.programmers.etc.level2;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        int left = 1, right = 1;
        int tmp = 1;

        while (left <= right && right <= n) {
            if (tmp < n) {
                right++;
                tmp += right;
            } else if (tmp > n) {
                tmp -= left;
                left++;
            } else {
                answer++;
                right++;
                tmp += right;
            }
        }

        return answer;
    }
}
