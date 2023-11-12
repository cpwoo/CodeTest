package CodeTest.Java.programmers.etc.level3;

public class 억억단을외우자 {
    public int[] solution(int e, int[] starts) {
        int[] num = new int[e+1];
        
        for (long i=1; i<=e; i++) {
            if (i*i <= e) num[(int)(i*i)] += 1;
            for (long j=1; j<=e; j++) {
                if (i*j > e) break;
                num[(int)(i*j)] += 2;
            }
        }

        int _min = Integer.MAX_VALUE;
        for (int s : starts) _min = Math.min(_min, s);

        int[] freq = new int[e+1];
        freq[e] = e;
        for (int i=e-1; i>=_min; i--) {
            freq[i] = (num[freq[i+1]]<=num[i]) ? i : freq[i+1];
        }
        
        int[] answer = new int[starts.length];
        for (int i=0; i<starts.length; i++) {
            answer[i] = freq[starts[i]];
        }

        return answer;
    }
}
