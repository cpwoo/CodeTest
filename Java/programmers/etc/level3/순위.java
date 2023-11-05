package CodeTest.Java.programmers.etc.level3;

public class 순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] board = new int[n][n];

        for (int[] result : results) {
            int a = result[0], b = result[1];
            board[a-1][b-1] = 1;
            board[b-1][a-1] = -1;
        }

        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (i == j || board[i][j] == 1 || board[i][j] == -1) {
                        continue;
                    }
                    if (board[i][k] == 1 && board[k][j] == 1) {
                        board[i][j] = 1;
                        board[j][i] = -1;
                        board[k][i] = -1;
                        board[j][k] = -1;
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            int cnt = 0;
            for (int j=0; j<n; j++) {
                if (board[i][j] == 0) cnt++;
            }
            if (cnt == 1) answer++;
        }

        return answer;
    }
}
