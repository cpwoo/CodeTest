package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 몸짱트레이너라이언의고민 {
    public int solution(int n, int m, int[][] timetable) {
        List<int[]> used = new ArrayList<>();
        for (int[] table : timetable) {
            used.add(new int[]{table[0], 1});
            used.add(new int[]{table[1], 2});
        }
        
        Collections.sort(used, (o1,o2)->{return (o1[0]==o2[0]) ? o1[1]-o2[1] : o1[0]-o2[0];});

        int _max = 0, people = 0;
        for (int[] u : used) {
            if (u[1] == 1) {
                people++;
            } else {
                people--;
            }
            _max = Math.max(_max, people);
        }

        if (_max <= 1) return 0;
        
        List<int[]> list = new ArrayList<>();
        for (int dist=2*(n-1); dist>=1; dist--) {
            for (int sy=0; sy<n; sy++) {
                list.clear();
                int cnt = 0;
                for (int i=0; i<n; i++) {
                    for (int j=0; j<n; j++) {
                        if (i == 0 && j < sy) continue;
                        boolean flag = true;
                        for (int[] p : list) {
                            if (Math.abs(p[0]-i)+Math.abs(p[1]-j) >= dist) continue;
                            flag = false;
                            break;
                        }
                        if (flag) {
                            cnt++;
                            if (cnt == _max) return dist;
                            list.add(new int[]{i, j});
                        }
                    }
                }
            }
        }

        return 0;
    }
}
