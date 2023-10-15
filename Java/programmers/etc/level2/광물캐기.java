package CodeTest.Java.programmers.etc.level2;

public class 광물캐기 {
    int[][] arr = new int[][]{{1,1,1},{5,1,1},{25,5,1}};
    int res = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        dfs(0, picks[0], picks[1], picks[2], minerals, 0);
        return res;
    }

    private void dfs(int idx, int d, int ir, int s, String[] minerals, int p) {
        if (idx >= minerals.length || (d == 0 && ir == 0 && s == 0)) {
            res = Math.min(res, p);
            return;
        }

        int dp = 0, ip = 0, sp = 0;
        for (int i=idx; i<Math.min(idx+5, minerals.length); i++) {
            String mineral = minerals[i];
            int x = 0;
            if (mineral.equals("iron")) x = 1;
            if (mineral.equals("stone")) x = 2;
            dp += arr[0][x];
            ip += arr[1][x];
            sp += arr[2][x];
        }

        if (d != 0) {
            dfs(idx+5, d-1, ir, s, minerals, p+dp);
        }
        if (ir != 0) {
            dfs(idx+5, d, ir-1, s, minerals, p+ip);
        }
        if (sp != 0) {
            dfs(idx+5, d, ir, s-1, minerals, p+sp);
        }
    }
}
