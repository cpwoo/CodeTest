package CodeTest.Java.programmers.etc.level2;

public class 유사칸토어비트열 {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for (long i=l-1; i<r; i++) {
            answer += check(i);
        }
        
        return answer;
    }
    
    private int check(long idx) {
        if (idx%5 == 2) return 0;
        else if (idx < 5) return 1;
        else return check(idx/5);
    }
}
