package CodeTest.Java.programmers.etc.level4;

public class 짝수행세기 {
    private static final int MOD = 10000019;

    public int solution(int[][] a) {
        int row = a.length, col = a[0].length;

        int[] num = new int[col+1];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (a[i][j] == 1) num[j]++;
            }
        }

        long[][] comb = new long[row+1][row+1];
        comb[0][0] = 1;
        for (int i=1; i<row+1; i++) {
            for (int j=0; j<i+1; j++) {
                if (j == 0 || i == j) comb[i][j] = 1;
                else comb[i][j] = (comb[i-1][j-1]+comb[i-1][j])%MOD;
            }
        }

        long[][] dp = new long[col+2][row+1];
        dp[1][row-num[0]] = comb[row][row-num[0]];

        for (int c=1; c<col+1; c++) {
            for (int r=0; r<row+1; r++) {
                if (dp[c][r] == 0) continue;

                for (int one=0; one<num[c]+1; one++) {
                    int nxt = (r-one) + (num[c]-one);
                    if (nxt > row || r < one) continue;
                    long cases = ((comb[r][one])*comb[row-r][num[c]-one])%MOD;
                    dp[c+1][nxt] += (dp[c][r]*cases)%MOD;
                }
            }
        }

        return (int) dp[col][row];
    }
}
