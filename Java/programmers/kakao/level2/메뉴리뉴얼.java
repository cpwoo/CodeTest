package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 메뉴리뉴얼 {
    static Map<String, Integer> map;

    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        map = new HashMap<>();

        for (int i=0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for (int course_size : course) {
            for (String order : orders) {
                combination("", order, course_size);
            }

            if (!map.isEmpty()) {
                List<Integer> cntList = new ArrayList<>(map.values());
                int _max = Collections.max(cntList);

                if (_max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == _max) answer.add(key);
                    }
                }
                map.clear();
            }
        }

        Collections.sort(answer);
        return answer;
    }

    private static void combination(String order, String others, int cnt) {
        if (cnt == 0) {
            map.put(order, map.getOrDefault(order,0)+1);
            return;
        }
        for (int i=0; i<others.length(); i++) {
            combination(order+others.charAt(i), others.substring(i+1), cnt-1);
        }
    }
}
