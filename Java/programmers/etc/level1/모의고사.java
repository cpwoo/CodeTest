package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 모의고사 {
    public List<Integer> solution(int[] answers) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{2,1,2,3,2,4,2,5};
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        
        for (int i=0; i<answers.length; i++) {
            int answer = answers[i];
            if (answer == a[i%a.length]) score[0]++;
            if (answer == b[i%b.length]) score[1]++;
            if (answer == c[i%c.length]) score[2]++;
        }
        
        List<Integer> ret = new ArrayList<>();
        int _max = Math.max(score[0], Math.max(score[1], score[2]));
        for (int i=0; i<3; i++) {
            if (score[i] == _max) ret.add(i+1);
        }
        
        return ret;
    }
}
