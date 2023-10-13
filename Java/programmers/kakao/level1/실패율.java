package CodeTest.Java.programmers.kakao.level1;

import java.util.*;

public class 실패율 {
    public List<Integer> solution(int N, int[] stages) {        
        int[] Fail = new int[N+2];
        int[] Total = new int[N+1];
        
        for (int stage : stages) {
            Fail[stage]++;
        }
        
        Total[N] = Fail[N]+Fail[N+1];
        for (int i=N-1; i>=1; i--) {
            Total[i] = Fail[i]+Total[i+1];
        }

        HashMap<Integer, Double> failMap = new HashMap<>();
        for (int i=1; i<=N; i++) {
            if (Fail[i] == 0 || Total[i] == 0) {
                failMap.put(i, 0.0);
            } else {
                failMap.put(i, (double) Fail[i]/Total[i]);
            }
        }
             
        List<Integer> answer = new ArrayList<>(failMap.keySet());
        Collections.sort(answer, (o1, o2) -> Double.compare(failMap.get(o2), failMap.get(o1)));
        return answer;
    }
}
