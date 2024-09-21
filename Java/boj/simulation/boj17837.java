package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj17837 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};

    private static int n, board[][], horse[][];
    private static List<Integer> chess[][];
    
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
        int k = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        chess = new ArrayList[n][n];
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            chess[i][j] = new ArrayList<>();
        }

        horse = new int[k][3];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                horse[i][j] = Integer.parseInt(st.nextToken())-1;
            }
            chess[horse[i][0]][horse[i][1]].add(i);
        }

        int turn = 0;

        while(true) {
            boolean flag = false;
            if(turn > 1000) {
                bw.write("-1");
                return;
            }

            for(int l=0; l<k; l++) {
                if(!move(l)) {
                    flag = true;
                    break;
                }
            }

            turn++;
            if(flag) {
                bw.write(turn+"");
                return;
            }
        }
    }

    private static boolean move(int num) {
        int x = horse[num][0], y = horse[num][1], d = horse[num][2];
        int nx = x+dx[d], ny = y+dy[d];

        if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 2) {
            if(d == 0 || d == 2) d++;
            else if(d == 1 || d == 3) d--;
            horse[num][2] = d;
            nx = x+dx[d]; ny = y+dy[d];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 2) return true;
        }

        List<Integer> horseMove = new ArrayList<>();
        int idx = chess[x][y].indexOf(num);

        for(int i=idx; i<chess[x][y].size(); i++) {
            horseMove.add(chess[x][y].get(i));
        }
        chess[x][y].subList(idx, chess[x][y].size()).clear();

        if(board[nx][ny] == 1) Collections.reverse(horseMove);

        for(int h : horseMove) {
            horse[h][0] = nx; horse[h][1] = ny; chess[nx][ny].add(h);
        }

        return chess[nx][ny].size() < 4;
    }

}
