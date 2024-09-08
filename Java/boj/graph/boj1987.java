package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1987 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        char[][] board = new char[R][C];
        for(int i=0; i<R; i++) board[i] = br.readLine().toCharArray();

        int ret = 1;

        Stack<int[]> stk = new Stack<>();
        stk.push(new int[]{0, 0, 1<<(board[0][0]-'A'), 1});

        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int x = cur[0], y = cur[1], state = cur[2], length = cur[3];

            ret = Math.max(ret, length);

            for (int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];

                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    int nextState = state|(1<<(board[nx][ny]-'A'));
                    if ((state&(1<<(board[nx][ny]-'A'))) == 0) {
                        stk.push(new int[]{nx, ny, nextState, length+1});
                    }
                }
            }
        }

        bw.write(ret+"");
    }

}
