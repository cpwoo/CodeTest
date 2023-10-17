package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 우박수열정적분 {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> hail = new ArrayList<>();
        
        while (k>1) {
            hail.add(k);
            if (k%2 == 1) {
                k = k*3+1;
            } else {
                k /= 2;
            }
        }
        hail.add(k);
        
        double[] answer = new double[ranges.length];
        
        for (int i=0; i<ranges.length; i++) {
            int a = ranges[i][0], b = ranges[i][1];
            if (a > b+hail.size()-1) {
                answer[i] = -1;
                continue;
            } else if (a == b+hail.size()-1) {
                answer[i] = 0;
                continue;
            }
            
            double dimension = 0;
            for (int j=a; j<b+hail.size()-1; j++) {
                dimension += (hail.get(j)+hail.get(j+1))/2.0;
            }
            
            answer[i] = dimension;
        }
        
        return answer;
    }
}
