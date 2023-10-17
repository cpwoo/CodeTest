package CodeTest.Java.programmers.etc.level2;

public class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i=0; i<=d; i+=k) {
            long dd = (long) d*d, ii = (long) i*i;
            int tmp = (int) Math.sqrt(dd-ii);
            answer += (tmp/k)+1;
        }
        
        return answer;
    }
}
