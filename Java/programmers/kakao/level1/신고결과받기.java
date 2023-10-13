package CodeTest.Java.programmers.kakao.level1;

import java.util.*;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        Map<String, HashSet<String>> reportedMap = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();

        for (int i=0; i<n; i++) {
            HashSet<String> reportingId = new HashSet<>();
            reportedMap.put(id_list[i], reportingId);
            answerMap.put(id_list[i], 0);
        }

        for (String re : report) {
            String[] st = re.split(" ");
            reportedMap.get(st[1]).add(st[0]);
        }

        for (String reportedUser : reportedMap.keySet()) {
            HashSet<String> userForSend = reportedMap.get(reportedUser);
            if (userForSend.size() >= k) {
                for (String userId : userForSend) {
                    answerMap.put(userId, answerMap.get(userId)+1);
                }
            }
        }

        for (int i=0; i<n; i++) {
            answer[i] = answerMap.get(id_list[i]);
        }

        return answer;
    }
}
