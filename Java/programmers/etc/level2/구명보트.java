package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int l = 0, r = people.length-1;

        while (l <= r) {
            if (people[l]+people[r] > limit) {
                answer++;
                r--;
            } else {
                answer++;
                r--;
                l++;
            }
        }

        return answer;
    }
}
