package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 당구연습 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i=0; i<balls.length; i++) {
            int bx = balls[i][0], by = balls[i][1];
            int[] tmp = new int[4];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            int[][] can = new int[][]{{-bx,by},{bx,-by},{2*m-bx,by},{bx,2*n-by}};
            for (int j=0; j<4; j++) {
                int x = can[j][0], y = can[j][1];
                if (startX == bx) {
                    if ((y < by && by < startY) || (startY < by && by < y)) continue;
                }
                if (startY == by) {
                    if ((x < bx && bx < startX) || (startX < bx && bx < x)) continue;
                }
                tmp[j] = (startX-x)*(startX-x) + (startY-y)*(startY-y);
            }
            for (int j=0; j<4; j++) System.out.println(tmp[j]);
            answer[i] = Math.min(Math.min(tmp[0], tmp[1]), Math.min(tmp[2], tmp[3]));
        }

        return answer;
    }
}
