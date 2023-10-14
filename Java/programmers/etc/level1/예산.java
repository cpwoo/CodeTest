package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 예산 {
    public int solution(int[] costs, int budget) {
        Arrays.sort(costs);
        int answer = 0;
        for (int cost : costs) {
            if (budget >= cost) budget -= cost;
            else break;
            answer++;
        }
        return answer;
    }
}
