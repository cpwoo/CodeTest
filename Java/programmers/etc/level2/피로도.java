package CodeTest.Java.programmers.etc.level2;

public class 피로도 {
    static boolean check[];
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    private static void dfs(int tired, int[][] dungeons, int cnt) {
        for (int i=0; i<dungeons.length; i++) {
            if (!check[i] && dungeons[i][0] <= tired) {
                check[i] = true;
                dfs(tired-dungeons[i][1], dungeons, cnt+1);
                check[i] = false;
            }
        }
        answer = Math.max(answer, cnt);
    }
}
