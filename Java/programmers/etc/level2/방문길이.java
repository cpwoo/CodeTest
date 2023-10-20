package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 방문길이 {
    static Map<String, int[]> map = new HashMap<>();
    
    public int solution(String dirs) {
        map.put("U", new int[]{-1,0});
        map.put("D", new int[]{1,0});
        map.put("L", new int[]{0,-1});
        map.put("R", new int[]{0,1});
        
        int x = 0, y = 0;
        int[][][][] visited = new int[11][11][11][11];

        for (String d : dirs.split("")) {
            int[] values = map.get(d);
            int dx = values[0], dy = values[1];
            int nx = x+dx, ny = y+dy;
            if (-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5) {
                visited[x+5][y+5][nx+5][ny+5] = 1;
                visited[nx+5][ny+5][x+5][y+5] = 1;
                x = nx; y = ny;
            }
        }
        
        int answer = 0;
        for (int a=0; a<11; a++) {
            for (int b=0; b<11; b++) {
                for (int c=0; c<11; c++) {
                    for (int d=0; d<11; d++) {
                        answer += visited[a][b][c][d];
                    }
                }
            }
        }
        
        return answer/2;
    }
}
