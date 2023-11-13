package CodeTest.Java.programmers.etc.level4;

public class 쿠키구입 {
    public int solution(int[] cookie) {
        int n = cookie.length;
        int answer = 0;

        for (int i=0; i<n-1; i++) {
            int leftSum = cookie[i], leftIdx = i;
            int rightSum = cookie[i+1], rightIdx = i+1;

            while (true) {
                if (leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                }
                if (leftIdx > 0 && leftSum <= rightSum) {
                    leftIdx--;
                    leftSum += cookie[leftIdx];
                }
                else if (rightIdx < n-1 && rightSum <= leftSum) {
                    rightIdx++;
                    rightSum += cookie[rightIdx];
                }
                else break;
            }
        }
        
        return answer;
    }
}
