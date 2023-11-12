package CodeTest.Java.programmers.etc.level4;

import java.util.*;

public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int answer = 0;
        int left = 1, right = distance;
        while (left <= right) {
            int mid = (left+right)/2;
            if (check(distance, rocks, mid) <= n) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return answer;
    }

    private static int check(int distance, int[] rocks, int mid) {
        int before = 0, end = distance;

        int cnt = 0;

        for (int i=0; i<rocks.length; i++) {
            if (rocks[i]-before < mid) {
                cnt++;
                continue;
            }
            before = rocks[i];
        }
        
        if (end-before < mid) cnt++;

        return cnt;
    }
}
