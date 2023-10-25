package CodeTest.Java.programmers.etc.level3;

public class 선입선출스케줄링 {
    public int solution(int n, int[] cores) {
        int c = cores.length;
        
        if (n <= c) return n;
        
        n -= c;
        int _max = 0;
        for (int core : cores) {
            _max = Math.max(_max, core);
        }
        
        int answer = 0;
        int left = 1, right = _max*n;
        while (left <= right) {
            int mid = (left+right)/2;
            int capacity = 0;
            for (int core : cores) {
                capacity += mid/core;
            }
            if (capacity >= n) {
                right = mid-1;
                answer = mid;
            } else {
                left = mid+1;
            }
        }

        for (int core : cores) {
            n -= (answer-1)/core;
        }

        for (int i=0; i<c; i++) {
            if (answer%cores[i] == 0) {
                n -= 1;
                if (n == 0) return i+1;
            }
        }
        
        return 0;
    }
}
