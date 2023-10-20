package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        List<String[]> tmp = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (int i=0; i<record.length; i++) {
            String[] cmd = record[i].split(" ");
            if (cmd.length == 3) {
                String state = cmd[0], ids = cmd[1], nick = cmd[2];
                map.put(ids, nick);
                if (state.equals("Enter")) {
                    tmp.add(new String[]{state, ids});
                }
            } else {
                String state = cmd[0], ids = cmd[1];
                tmp.add(new String[]{state, ids});
            }
        }

        String[] answer = new String[tmp.size()];
        
        for (int i=0; i<tmp.size(); i++) {
            if (tmp.get(i)[0].equals("Enter")) {
                answer[i] = map.get(tmp.get(i)[1]) + "님이 들어왔습니다.";
            } else {
                answer[i] = map.get(tmp.get(i)[1]) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
