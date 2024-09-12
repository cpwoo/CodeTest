package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj6087 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dr = {0,0,-1,1}, dc = {-1,1,0,0};

    private static int W, H, dstR, dstC;
    private static char A[][];
    private static boolean V[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        A = new char[H][W];
        for(int i=0; i<H; i++) A[i] = br.readLine().toCharArray();

        V = new boolean[H][W];

        List<int[]> connPoints = new ArrayList<>();
        for(int r=0; r<H; r++) for(int c=0; c<W; c++) {
            if(A[r][c] == 'C') connPoints.add(new int[]{r, c});
        }

        int startR = connPoints.get(0)[0], startC = connPoints.get(0)[1];
        dstR = connPoints.get(1)[0]; dstC = connPoints.get(1)[1];

        bw.write(bfs(startR, startC)+"");
    }

    private static int bfs(int startR, int startC) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC, -1});

        V[startR][startC] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0], curC = cur[1], cnt = cur[2];
            
            if(curR == dstR && curC == dstC) return cnt;

            for(int i=0; i<4; i++) {
                int nxtR = curR, nxtC = curC;
                while(true) {
                    nxtR += dr[i]; nxtC += dc[i];
                    if(0 <= nxtR && nxtR < H && 0 <= nxtC && nxtC < W) {
                        if(A[nxtR][nxtC] == '*') break;
                        if(!V[nxtR][nxtC]) {
                            V[nxtR][nxtC] = true;
                            q.add(new int[]{nxtR, nxtC, cnt+1});
                        }
                    } 
                    else break;
                }
            }
        }

        return -1;
    }

}
