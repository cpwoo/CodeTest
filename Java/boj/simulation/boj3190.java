package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj3190 {
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
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y-1][x-1] = 1;
        }

        Map<Integer, Character> times = new HashMap<>();

        int L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            times.put(t, c);
        }

        int dir = 1, time = 1, y = 0, x = 0;

        Deque<int[]> visited = new ArrayDeque<>();
        visited.add(new int[]{y, x});
        board[y][x] = 2;

        while(true) {
            int ny = y+dy[dir], nx = x+dx[dir];

            if(0 <= ny && ny < N && 0 <= nx && nx < N && board[ny][nx] != 2) {
                if(board[ny][nx] == 0) {
                    int[] t = visited.poll();
                    board[t[0]][t[1]] = 0;
                }
                board[ny][nx] = 2;
                visited.add(new int[]{ny, nx});
                
                if(times.containsKey(time)) {
                    dir = change(dir, times.get(time));
                }
                time++;
                y = ny; x = nx;
            }
            else {
                bw.write(time+"");
                break;
            }
        }
    }

    private static int change(int d, char c) {
        return (c == 'L') ? (d+3)%4 : (d+1)%4;
    }

}
