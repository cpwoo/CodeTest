package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        List<Integer> table = new ArrayList<>();
        for (String time : timetable) {
            table.add(Integer.parseInt(time.substring(0, 2))*60 + Integer.parseInt(time.substring(3)));
        }
        Collections.sort(table);
        
        int[] busTime = new int[n];
        for (int i=0; i<n; i++) {
            busTime[i] = 540+t*i;
        }
        
        int i = 0;
        int answer = 0;
        for (int bt : busTime) {
            int cnt = 0;
            while (cnt < m && i < table.size() && table.get(i) <= bt) {
                i++;
                cnt++;
            }
            if (cnt < m) answer = bt;
            else answer = table.get(i-1)-1;
        }
        
        return String.format("%02d:%02d", answer/60, answer%60);
    }
}
