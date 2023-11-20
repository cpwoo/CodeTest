package CodeTest.Java.programmers.etc.level5;

import java.util.*;

public class 방의개수 {
    private static int[][] d = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

    public int solution(int[] arrows) {
        Set<String> v = new HashSet<>();
        Set<String> e = new HashSet<>();

        int x = 0, y = 0;
        v.add(""+x+","+y);

        for (int arrow : arrows) {
            for (int i=0; i<2; i++) {
                
                int nx = x+d[arrow][0], ny = y+d[arrow][1];
                v.add(""+nx+","+ny);

                e.add(""+(x+nx)+","+(y+ny));
                x = nx; y = ny; 
            }
        }

        return 1-v.size()+e.size();
    }
}
