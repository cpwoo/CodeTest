package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1,o2) -> o1[col-1]!=o2[col-1] ? o1[col-1]-o2[col-1] : o2[0]-o1[0]);
        
        for (int i=row_begin-1; i<row_end; i++) {
            int tmp = 0;
            for (int j=0; j<data[0].length; j++) {
                tmp += data[i][j]%(i+1);
            }
            answer ^= tmp;
        }
        
        return answer;
    }
}
