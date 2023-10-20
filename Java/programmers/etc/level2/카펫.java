package CodeTest.Java.programmers.etc.level2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int total = brown+yellow;
        int a = 0, b = 0;

        for (int i=1; i<Math.sqrt(total)+1; i++) {
            a = i; b = total/i;
            if (total%i == 0 && 2*(a+b-2) == brown) {
                break;
            }
        }
        
        return new int[]{b, a};
    }
}
