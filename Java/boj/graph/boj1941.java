package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1941 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};

    private static char[][] board;
    private static int cnt;
    private static Stack<Integer> stk;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        board = new char[5][5];
        for(int i=0; i<5; i++) board[i] = br.readLine().toCharArray();

        cnt = 0;
        stk = new Stack<>();

        dfs(0, 0, 0, 0);
        
        bw.write(cnt+"");
    }

    private static void dfs(int depth, int idx, int sCnt, int yCnt) {
        if(depth == 7 && sCnt >= 4) {
            if(chk()) cnt++;
            return;
        }

        if(yCnt >= 4 || idx >= 25 || depth > 7) return;

        int y = idx/5, x = idx%5;

        stk.add(idx);

        if(board[y][x] == 'Y') dfs(depth+1, idx+1, sCnt, yCnt+1);
        else if(board[y][x] == 'S') dfs(depth+1, idx+1, sCnt+1, yCnt);

        stk.pop();

        dfs(depth, idx+1, sCnt, yCnt);
    }

    private static boolean chk() {
        boolean[][] visited = new boolean[5][5];
        for(int idx : stk) visited[idx/5][idx%5] = true;

        Deque<Integer> q = new ArrayDeque<>();
        q.add(stk.get(0));

        int depth = 0;
        visited[stk.get(0)/5][stk.get(0)%5] = false;

        while(!q.isEmpty()) {
            int idx = q.poll();
            depth++;
            int y = idx/5, x = idx%5;

            for(int[] direc : direction) {
                int ny = y+direc[0], nx = x+direc[1];
                if(0 <= ny && ny < 5 && 0 <= nx && nx < 5 && visited[ny][nx]) {
                    visited[ny][nx] = false;
                    q.add(5*ny+nx);
                }
            }
        }

        return depth == 7;
    }

}
