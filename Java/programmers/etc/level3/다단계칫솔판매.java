package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 다단계칫솔판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> graph = new HashMap<>();

        int n = enroll.length;
        for (int i=0; i<n; i++) {
            map.put(enroll[i], 0);
            graph.put(enroll[i], referral[i]);
        }

        int m = seller.length;
        for (int i=0; i<m; i++) {
            String s = seller[i];
            int a = amount[i];

            int money = a*100;
            int rate = money/10;
            map.put(s, map.get(s)+(money-rate));
            String x = graph.get(s);

            while (!x.equals("-")) {
                if (rate == 0) break;
                map.put(x, map.get(x)+(rate-rate/10));
                rate /= 10;
                x = graph.get(x);
            }
        }

        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            answer[i] = map.get(enroll[i]);
        }

        return answer;
    }
}
