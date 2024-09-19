package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj15683 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    private static final Map<Integer, int[][]> dir = new HashMap<>();
    
    static {
        dir.put(1, new int[][]{{0},{1},{2},{3}});
        dir.put(2, new int[][]{{0,2},{1,3}});
        dir.put(3, new int[][]{{0,1},{1,2},{2,3},{3,0}});
        dir.put(4, new int[][]{{0,1,2},{1,2,3},{2,3,0},{3,0,1}});
        dir.put(5, new int[][]{{0,1,2,3}});
    };

    private static int n, m, ret;
    private static List<int[]> cctv;
    

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cctv = new ArrayList<>();
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] != 0 && board[i][j] != 6) {
                cctv.add(new int[]{i, j, board[i][j]});
            }
        }

        ret = Integer.MAX_VALUE;
        dfs(0, board);

        bw.write(ret+"");
    }

    private static void dfs(int depth, int[][] board) {
        int[][] tmp = new int[n][m];
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            tmp[i][j] = board[i][j];
        }

        if(depth == cctv.size()) {
            int cnt = 0;
            for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
                if(tmp[i][j] == 0) cnt++;
            }
            ret = Math.min(ret, cnt);
            return;
        }

        int[] cc = cctv.get(depth);
        int x = cc[0], y = cc[1], c = cc[2];
        for(int[] d : dir.get(c)) {
            watch(x, y, d, tmp);
            dfs(depth+1, tmp);
            for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
                tmp[i][j] = board[i][j];
            }
        }
    }

    private static void watch(int x, int y, int[] dirs, int[][] tmp) {
        for (int d : dirs) {
            int nx = x, ny = y;
            while(true) {
                nx += dx[d]; ny += dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || tmp[nx][ny] == 6) break;
                if(tmp[nx][ny] == 0) tmp[nx][ny] = '#';
            }
        }
    }

}
