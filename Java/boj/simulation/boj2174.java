package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj2174 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dy = {-1,0,1,0}, dx = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[B][A];

        int[][] robot = new int[N+1][3];

        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            board[B-y][x-1] = true;
            
            robot[i][0] = B-y;
            robot[i][1] = x-1;
            
            switch(st.nextToken().charAt(0)) {
                case('N'): {
                    robot[i][2] = 0;
                    break;
                }
                case('E'): {
                    robot[i][2] = 1;
                    break;
                }
                case('S'): {
                    robot[i][2] = 2;
                    break;
                }
                case('W'): {
                    robot[i][2] = 3;
                    break;
                }
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());

            for(int j=0; j<repeat; j++) {
                if(cmd == 'F') {
                    int y = robot[target][0], x = robot[target][1], dir = robot[target][2];
                    int ny = y+dy[dir], nx = x+dx[dir];
                    
                    if(ny < 0 || ny >= B || nx < 0 || nx >= A) {
                        bw.write(String.format("Robot %d crashes into the wall", target));
                        return;
                    }
                    else if(board[ny][nx]) {
                        for(int k=1; k<N+1; k++) {
                            if(ny == robot[k][0] && nx == robot[k][1]) {
                                bw.write(String.format("Robot %d crashes into robot %d", target, k));
                                return;
                            }
                        }
                    }
                    else {
                        board[y][x] = false;
                        board[ny][nx] = true;
                        robot[target][0] = ny;
                        robot[target][1] = nx;
                    }
                }
                else if(cmd == 'L') robot[target][2] = (robot[target][2]+3)%4;
                else robot[target][2] = (robot[target][2]+1)%4;
            }
        }
        
        bw.write("OK");
    }

}
