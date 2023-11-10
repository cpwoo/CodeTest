package CodeTest.Java.programmers.kakao.level4;

import java.util.*;

public class 호텔방배정 {
    private static Map<Long, Long> rooms;

    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;

        long[] answer = new long[n];
        rooms = new HashMap<>();

        for (int i=0; i<n; i++) {
            answer[i] = find(room_number[i]);
        }

        return answer;
    }

    private static long find(long num) {
        if (!rooms.containsKey(num)) {
            rooms.put(num, num+1);
            return num;
        }

        long empty = find(rooms.get(num));
        rooms.put(num, empty+1);
        
        return empty;
    }
}
