package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        List<int[]> answer = new ArrayList<>();
        int tot = 0, left = 0, right = 0;
        int n = sequence.length;

        while (left <= right && right < n) {
            tot += sequence[right];
            if (tot >= k) {
                while (tot > k) {
                    tot -= sequence[left];
                    left++;
                }
                if (tot == k) answer.add(new int[]{left, right});
            }
            right++;
        }

        answer.sort((o1, o2) -> {
            int d1 = o1[1]-o1[0];
            int d2 = o2[1]-o2[0];
            return d1 == d2 ? o1[0]-o2[0] : (d1-d2);
        });

        return answer.get(0);
    }
}
