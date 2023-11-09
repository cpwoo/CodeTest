package CodeTest.Java.programmers.etc.level3;

public class 이차원동전뒤집기 {
    public int solution(int[][] beginning, int[][] target) {
        int m = beginning.length, n = beginning[0].length;

        int[][] table = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                table[i][j] = beginning[i][j]^target[i][j];
            }
        }

        int cnt = 0;
        for (int i=1; i<m; i++) {
            if (!equal(table[i], table[0])) {
                cnt++;
                int[] tmp = new int[n];
                for (int j=0; j<n; j++) {
                    tmp[j] = table[i][j]^1;
                }
                if (!equal(tmp, table[0])) return -1;
            }
        }

        int ret = 0;
        for (int j=0; j<n; j++) ret += table[0][j];

        return Math.min((cnt+ret), (m-cnt)+(n-ret));
    }

    private static boolean equal(int[] a, int[] b) {
        for (int idx=0; idx<a.length; idx++) {
            if (a[idx] != b[idx]) return false; 
        }
        return true;
    }
}
