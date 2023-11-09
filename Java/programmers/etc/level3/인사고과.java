package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 인사고과 {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] target = scores[0];

        Arrays.sort(scores, (o1, o2) -> {
            return (o1[0]==o2[0]) ? o1[1]-o2[1] : o2[0]-o1[0]; 
        });

        int _min = 0;
        for (int[] score : scores) {
            if (target[0] < score[0] && target[1] < score[1]) return -1;
            if (_min <= score[1]) {
                if (target[0]+target[1] < score[0]+score[1]) answer++;
                _min = score[1];
            }
        }

        return answer;
    }
}
