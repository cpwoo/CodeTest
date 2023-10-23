package CodeTest.Java.programmers.etc.level2;

public class 가장큰정사각형찾기 {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length, m = board[0].length;
        int[][] dp = new int[n+1][m+1];

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                if (board[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer*answer;
    }
}
