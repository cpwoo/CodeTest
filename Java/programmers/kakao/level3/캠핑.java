package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 캠핑 {
    public int solution(int n, int[][] data) {
        Arrays.sort(data, (o1,o2)->{return (o1[0]==o2[0]) ? o1[1]-o2[1] : o1[0]-o2[0];});

        int answer = 0;

        for (int i=0; i<data.length; i++) {
            for (int j=i+1; j<data.length; j++) {
                if (data[i][0]==data[j][0] || data[i][1]==data[j][1]) continue;
                boolean flag = true;
                for (int k=i+1; k<j; k++) {
                    if (data[i][0] < data[k][0] && data[k][0] < data[j][0]) {
                        int _min = Math.min(data[i][1], data[j][1]);
                        int _max = Math.max(data[i][1], data[j][1]);
                        if (_min < data[k][1] && data[k][1] < _max) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) answer++;
            }
        }

        return answer;
    }
}
