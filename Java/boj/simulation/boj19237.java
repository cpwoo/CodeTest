package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj19237 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int N, K, arr[][], smell[][][], direc[], priorities[][][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        smell = new int[N][N][2];

        direc = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) direc[i] = Integer.parseInt(st.nextToken());

        priorities = new int[M][4][4];
        for(int i=0; i<M; i++) for(int j=0; j<4; j++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<4; k++) {
                priorities[i][j][k] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while(true) {
            updateSmell();
            arr = move();

            time++;

            boolean chk = true;
            for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
                if(arr[i][j] > 1) chk = false;
            }

            if(chk) {
                bw.write(time+"");
                break;
            }

            if(time >= 1000) {
                bw.write("-1");
                break;
            }
        }
    }

    private static void updateSmell() {
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            if(smell[i][j][1] > 0) smell[i][j][1]--;
            if(arr[i][j] != 0) {
                smell[i][j][0] = arr[i][j];
                smell[i][j][1] = K;
            }
        }
    }

    private static int[][] move() {
        int[][] tmp = new int[N][N];

        for(int x=0; x<N; x++) for(int y=0; y<N; y++) {
            if(arr[x][y] != 0) {
                int dir = direc[arr[x][y]-1];
                boolean found = false;
                for(int idx=0; idx<4; idx++) {
                    int nx = x+dx[priorities[arr[x][y]-1][dir-1][idx]-1];
                    int ny = y+dy[priorities[arr[x][y]-1][dir-1][idx]-1];

                    if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if(smell[nx][ny][1] == 0) {
                            direc[arr[x][y]-1] = priorities[arr[x][y]-1][dir-1][idx];
                            if(tmp[nx][ny] == 0) {
                                tmp[nx][ny] = arr[x][y];
                            }
                            else tmp[nx][ny] = Math.min(tmp[nx][ny], arr[x][y]);
                            
                            found = true;
                            break;
                        }
                    }
                }
                if(found) continue;

                for(int idx=0; idx<4; idx++) {
                    int nx = x+dx[priorities[arr[x][y]-1][dir-1][idx]-1];
                    int ny = y+dy[priorities[arr[x][y]-1][dir-1][idx]-1];
                    if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if(smell[nx][ny][0] == arr[x][y]) {
                            direc[arr[x][y]-1] = priorities[arr[x][y]-1][dir-1][idx];
                            tmp[nx][ny] = arr[x][y];
                            break;
                        }
                    }
                }
            }
        }

        return tmp;
    }

}
