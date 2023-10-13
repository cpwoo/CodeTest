package CodeTest.Java.programmers.etc.level1;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int eq = 0, zeros = 0;
        
        for (int lotto : lottos) {
            if (lotto == 0) zeros++;
            else {
                for (int win : win_nums) {
                    if (lotto == win) {
                        eq++;
                        break;
                    }
                }
            }
        }

        return new int[]{Math.min(7-(eq+zeros), 6), Math.min(7-eq, 6)};
    }
}
