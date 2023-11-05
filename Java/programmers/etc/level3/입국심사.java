package CodeTest.Java.programmers.etc.level3;

public class 입국심사 {
    public long solution(int n, int[] times) {
        int _max = 0;
        for (int time : times) {
            _max = Math.max(_max, time);
        }
        
        long answer = 0;
        long left = 0, right = (long) _max*n;
        
        while (left <= right) {
            long mid = (left+right)/2;
            long tmp = 0;
            for (int time : times) {
                tmp += mid/time;
            }
            if (tmp >= n) {
                right = mid-1;
                answer = mid;
            } else {
                left = mid+1;
            }
        }
        
        return answer;
    }
}
