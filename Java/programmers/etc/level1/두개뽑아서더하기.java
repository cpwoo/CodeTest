package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 두개뽑아서더하기 {
    public List<Integer> solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        int n = numbers.length;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }

        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            answer.add(iter.next());
        }

        Collections.sort(answer);
        return answer;
    }    
}
