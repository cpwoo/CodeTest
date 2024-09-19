package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj15685 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[101][101];
        List<Integer> move;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            arr[x][y] = true;

            move = new ArrayList<>();
            move.add(d);

            for(int j=0; j<g; j++) {
                int sz = move.size();
                for(int k=0; k<sz; k++) {
                    move.add((move.get(sz-k-1)+1)%4);
                }
            }

            for(int m : move) {
                int nx = x+dx[m], ny = y+dy[m];
                if(nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;
                arr[nx][ny] = true;
                x = nx; y = ny;
            }
        }

        int ret = 0;
        for(int i=0; i<100; i++) for(int j=0; j<100; j++) {
            if(arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]) {
                ret++;
            }
        }

        bw.write(ret+"");
    }

}
