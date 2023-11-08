package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 코딩테스트공부 {
    public int solution(int alp, int cop, int[][] problems) {
        int max_alp = 0, max_cop = 0;
        
        for (int[] problem : problems) {
            max_alp = Math.max(max_alp, problem[0]);
            max_cop = Math.max(max_cop, problem[1]);
        }

        alp = Math.min(alp, max_alp);
        cop = Math.min(cop, max_cop);

        int[][] dp = new int[max_alp+1][max_cop+1];
        for (int i=0; i<=max_alp; i++) {
            Arrays.fill(dp[i], (int)1e9);
        }

        dp[alp][cop] = 0;

        for (int i=alp; i<=max_alp; i++) {
            for (int j=cop; j<=max_cop; j++) {
                if (i+1 <= max_alp) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                }
                if (j+1 <= max_cop) {
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                }
            
                for (int[] problem : problems) {
                    int alp_req = problem[0], cop_req = problem[1];
                    int alp_rwd = problem[2], cop_rwd = problem[3];
                    int cost = problem[4];
                    
                    if (i >= alp_req && j >= cop_req) {
                        int nxt_alp = Math.min(max_alp, i+alp_rwd);
                        int nxt_cop = Math.min(max_cop, j+cop_rwd);
                        dp[nxt_alp][nxt_cop] = Math.min(dp[nxt_alp][nxt_cop], dp[i][j]+cost);
                    }
                }
            }
        }

        return dp[max_alp][max_cop];
    }
}
