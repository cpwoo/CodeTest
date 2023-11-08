package CodeTest.Java.programmers.etc.level3;

public class 카운트다운 {
    public int[] solution(int target) {
        int[][] dp = new int[target+1][2];
        for (int i=0; i<=target; i++) {
            dp[i][0] = target-i;
            dp[i][1] = target-i;
        }

        for (int i=target; i>=0; i--) {
            for (int j=20; j>=1; j--) {
                if (i >= 50) dp[i-50] = SingleOrBool(dp[i-50], dp[i]);
                if (i >= j) dp[i-j] = SingleOrBool(dp[i-j], dp[i]);
                else break;

                if (i >= 2*j) dp[i-2*j] = DoubleOrThree(dp[i-2*j], dp[i]);
                if (i >= 3*j) dp[i-3*j] = DoubleOrThree(dp[i-3*j], dp[i]);
            }
        }
        
        return dp[0];
    }

    private static int[] SingleOrBool(int[] a, int[] b) {
        if (a[0]>b[0]+1 || (a[0]==b[0]+1 && a[1]<b[1]+1)) {
            a[0] = b[0]+1; a[1] = b[1]+1;
        }
        return a;
    }
    
    private static int[] DoubleOrThree(int[] a, int[] b) {
        if (a[0]>b[0]+1 || (a[0]==b[0]+1 && a[1]<b[1])) {
            a[0] = b[0]+1; a[1] = b[1];
        }
        return a;
    }
}
