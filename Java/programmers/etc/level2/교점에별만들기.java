package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 교점에별만들기 {
    public String[] solution(int[][] line) {
        List<int[]> meets = new ArrayList<>();
        int _minX = Integer.MAX_VALUE, _maxX = Integer.MIN_VALUE;
        int _minY = Integer.MAX_VALUE, _maxY = Integer.MIN_VALUE;
        
        int n = line.length;
        for (int i=0; i<n-1; i++) {
            int x1 = line[i][0], y1 = line[i][1], c1 = line[i][2];
            for (int j=i+1; j<n; j++) {
                int x2 = line[j][0], y2 = line[j][1], c2 = line[j][2];
                if (x1*y2 == y1*x2) continue;
                long m = (long) x1*y2-y1*x2;
                long p = (long) y1*c2-c1*y2, q = (long) c1*x2-x1*c2;
                if (p%m == 0 && q%m == 0) {
                    int x = (int) (p/m), y = (int) (q/m);
                    _minX = Math.min(_minX, x);
                    _maxX = Math.max(_maxX, x);
                    _minY = Math.min(_minY, y);
                    _maxY = Math.max(_maxY, y);
                    meets.add(new int[]{x, y});
                }
            }
        }

        String[][] board = new String[_maxY-_minY+1][_maxX-_minX+1];

        for (int i=0; i<_maxY-_minY+1; i++) {
            for (int j=0; j<_maxX-_minX+1; j++) {
                board[i][j] = ".";
            }
        }

        for (int[] meet : meets) {
            int mx = meet[0], my = meet[1];
            board[_maxY-my][mx-_minX] = "*";
        }

        String[] answer = new String[_maxY-_minY+1];
        for (int i=0; i<_maxY-_minY+1; i++) {
            answer[i] = String.join("", board[i]);
        }

        return answer;
    }
}
