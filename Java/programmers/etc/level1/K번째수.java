package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for (int i=0; i<n; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }

        return answer;
    }
}
