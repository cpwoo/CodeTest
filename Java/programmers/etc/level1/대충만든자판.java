package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> idxMap = new HashMap<>();
        
        for (int i=0; i<keymap.length; i++) {
            for (int j=0; j<keymap[i].length(); j++) {
                char cur = keymap[i].charAt(j);
                if (idxMap.containsKey(cur)) {
                    int idx = idxMap.get(cur);
                    idxMap.put(cur, Math.min(idx, j+1));
                } else {
                    idxMap.put(cur, j+1);
                }
            }
        }

        int i = 0;
        for (String target : targets) {
            int cnt = 0;
            boolean flag = true;
            for (char cur : target.toCharArray()) {
                if (idxMap.containsKey(cur)) {
                    cnt += idxMap.get(cur);
                } else {
                    flag = false;
                    break;
                }
            }
            answer[i++] = flag ? cnt : -1;
        }

        return answer;
    }
}
