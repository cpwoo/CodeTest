package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        HashMap<String, Integer> idxMap = new HashMap<>();

        for (int i=0; i<n; i++) {
            idxMap.put(players[i], i);
        }

        for (String calling: callings) {
            int idx = idxMap.get(calling);
            if (idx > 0) {
                String tmp = players[idx-1];
                players[idx-1] = players[idx];
                players[idx] = tmp;

                idxMap.put(players[idx-1], idx-1);
                idxMap.put(players[idx], idx);
            }
        }

        return players;
    }
}
