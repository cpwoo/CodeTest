package CodeTest.Java.programmers.etc.level3;

public class 고고학최고의발견 {
    private static int N;
    private static int answer = Integer.MAX_VALUE;
    private static int[][] map;
    private static int[] rot;
    private static int[] dx = {0,0,0,1,-1};
    private static int[] dy = {0,1,-1,0,0};

    public int solution(int[][] clockHands) {
        N = clockHands.length;
        map = new int[N][N];
        rot = new int[N];
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = (4-clockHands[i][j])%4;
            }
        }

        dfs(0);
        return answer;
    }

    private static void dfs(int idx) {
        if (idx == N) {
            int[][] tmp = new int[N][N];
            int[] cur = new int[N];
            
            for (int i=0; i<N; i++) {
                cur[i] = rot[i];
                for (int j=0; j<N; j++) {
                    tmp[i][j] = map[i][j];
                }
            }

            int res = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    res += cur[j];
                    for (int d=0; d<5; d++) {
                        int nx = i+dx[d], ny = j+dy[d];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        tmp[nx][ny] = (tmp[nx][ny]-cur[j]+4)%4;
                    }
                }
                for (int j=0; j<N; j++) {
                    cur[j] = tmp[i][j];
                }
            }

            boolean flag = true;
            for (int i=0; i<N; i++) {
                if (cur[i] != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer = Math.min(answer, res);
            return;
        }

        for (int i=0; i<4; i++) {
            rot[idx] = i;
            dfs(idx+1);
        }
    }
}
