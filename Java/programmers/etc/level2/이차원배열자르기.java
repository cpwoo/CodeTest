package CodeTest.Java.programmers.etc.level2;

public class 이차원배열자르기 {
    public int[] solution(int n, long left, long right) {
        int x = (int) (right-left);
        int[] answer = new int[x+1];

        for (long i=left; i<=right; i++) {
            int d = (int) (i/n), v = (int) (i%n);
            int idx = (int) (i-left);
            answer[idx] = Math.max(d,v)+1;
        }

        return answer;
    }
}
