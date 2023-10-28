package CodeTest.Java.programmers.etc.level3;

// Math.ceil은 시간초과 가능성이 있다.

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        
        for (int station : stations) {
            int tmp = (station-w-start)/(2*w+1);
            if ((station-w-start)%(2*w+1)>0) tmp++; 
            answer += Math.max(tmp, 0);
            start = station+w+1;
        }
        
        if (n >= start) {
            int tmp = (n-start+1)/(2*w+1);
            if ((n-start+1)%(2*w+1)>0) tmp++;
            answer += tmp;
        }

        return answer;
    }
}
