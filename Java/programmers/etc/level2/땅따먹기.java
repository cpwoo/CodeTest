package CodeTest.Java.programmers.etc.level2;

public class 땅따먹기 {
    public int solution(int[][] land) {
        int n = land.length;

        for (int i=1; i<n; i++) {
            for (int j=0; j<4; j++) {
                int tmp = 0;
                for (int k=0; k<j; k++) {
                    tmp = Math.max(tmp, land[i-1][k]);
                }
                for (int k=j+1; k<4; k++) {
                    tmp = Math.max(tmp, land[i-1][k]);
                }
                land[i][j] += tmp;
            }
        }

        int answer = 0;
        for (int j=0; j<4; j++) {
            answer = Math.max(answer, land[n-1][j]);
        }

        return answer;
    }
}
