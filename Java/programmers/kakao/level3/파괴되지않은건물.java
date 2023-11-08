package CodeTest.Java.programmers.kakao.level3;

public class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int n = board.length, m = board[0].length;
        int[][] tmp = new int[n+1][m+1];

        for (int[] sk : skill) {
            int typ=sk[0], r1=sk[1], c1=sk[2], r2=sk[3], c2=sk[4], degree=sk[5];

            tmp[r1][c1] += typ == 2 ? degree : -degree;
            tmp[r1][c2+1] += typ == 2 ? -degree : degree;
            tmp[r2+1][c1] += typ == 2 ? -degree : degree;
            tmp[r2+1][c2+1] += typ == 2 ? degree : -degree;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                tmp[i][j+1] += tmp[i][j];
            }
        }

        for (int j=0; j<m; j++) {
            for (int i=0; i<n; i++) {
                tmp[i+1][j] += tmp[i][j];
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                board[i][j] += tmp[i][j];
                if (board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
