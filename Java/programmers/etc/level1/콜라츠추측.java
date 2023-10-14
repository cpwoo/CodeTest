package CodeTest.Java.programmers.etc.level1;

public class 콜라츠추측 {
    public int solution(long num) {
        int answer = 0;

        while(num != 1) {
            answer++;
            if (answer==500) return -1;
            num = (num%2==0) ? num/2 : num*3+1;
        }
        
        return answer;
    }
}
