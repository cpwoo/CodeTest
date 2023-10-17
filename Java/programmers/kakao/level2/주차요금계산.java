package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, Integer> map = new TreeMap<>();

        for (String record : records) {
            String[] temp = record.split(" ");
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= calc(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
        }
        
        int idx = 0;
        int[] ans = new int[map.size()];
        
        for (int time : map.values()) {
            if (time < 1) time += 1439;
            time -= fees[0];
            int cost = fees[1];
            if (time > 0) 
                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

            ans[idx++] = cost;
        }

        return ans;
    }

    private int calc(String time) {
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
    }
}
