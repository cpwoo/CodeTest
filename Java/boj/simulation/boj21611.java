package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj21611 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    
    private static int n, m, board[][], score[];
    private static List<int[]> spread;

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

        board = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        score = new int[3];

        spread = new ArrayList<>();

        init();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            magic(a-1, b);
        }

        int ret = 0;
        for(int i=0; i<3; i++) ret += (i+1)*score[i];

        bw.write(ret+"");
    }

    private static void init() {
        int[] dx = {0,1,0,-1}, dy = {-1,0,1,0};
        int x = n/2, y = n/2;
        int depth = 0;

        while(true) {
            for(int d=0; d<4; d++) {
                if(d%2 == 0) depth++;
                for(int i=0; i<depth; i++) {
                    x += dx[d]; y += dy[d];
                    spread.add(new int[]{x, y});

                    if(x == 0 && y == 0) return;
                }
            }
        }
    }

    private static void magic(int d, int r) {
        int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
        int x = n/2, y = n/2;

        for(int i=0; i<r; i++) {
            x += dx[d]; y += dy[d];
            if(x < 0 || x >= n || y < 0 || y >= n) break;
            board[x][y] = 0;
        }

        fill();
        while(bomb()) fill();
        group();
    }

    private static void fill() {
        Deque<int[]> blank = new ArrayDeque<>();
        for(int[] sp : spread) {
            int x = sp[0], y = sp[1];
            if(board[x][y] == 0) {
                blank.add(new int[]{x, y});
            }
            else if(board[x][y] > 0 && !blank.isEmpty()) {
                int[] nxt = blank.poll();
                int nx = nxt[0], ny = nxt[1];
                board[nx][ny] = board[x][y];
                board[x][y] = 0;
                blank.add(new int[]{x, y});
            }
        }
    }

    private static boolean bomb() {
        Deque<int[]> visited = new ArrayDeque<>();
        int cnt = 0, num = -1;
        boolean flag = false;

        for(int[] sp : spread) {
            int x = sp[0], y = sp[1];
            if(num == board[x][y]) {
                visited.add(new int[]{x, y});
                cnt++;
            }
            else {
                if(cnt >= 4) {
                    score[num-1] += cnt;
                    flag = true;
                }

                while(!visited.isEmpty()) {
                    int[] nxt = visited.poll();
                    int nx = nxt[0], ny = nxt[1];
                    if(cnt >= 4) board[nx][ny] = 0;
                }

                num = board[x][y];
                cnt = 1;
                visited.add(new int[]{x, y});
            }
        }

        return flag;
    }

    private static void group() {
        int cnt = 1;
        int tx = spread.get(0)[0], ty = spread.get(0)[1];
        int num = board[tx][ty];

        List<Integer> nums = new ArrayList<>();

        for(int i=1; i<spread.size(); i++) {
            int[] sp = spread.get(i);
            int x = sp[0], y = sp[1];
            
            if(num == board[x][y]) cnt++;
            else {
                nums.add(cnt); nums.add(num);
                num = board[x][y];
                cnt = 1;
            }
        }

        int idx = 0;
        for(int[] sp : spread) {
            int x = sp[0], y = sp[1];
            if(nums.isEmpty()) break;
            board[x][y] = nums.get(idx);
            idx++;
            if(idx == nums.size()) break;
        }
    }

}
