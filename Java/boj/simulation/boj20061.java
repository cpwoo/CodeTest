package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj20061 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int blue[][], green[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        blue = new int[4][6]; green = new int[6][4];
        int score = 0;

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dropBlue(t, x); dropGreen(t, y);

            for(int i=0; i<6; i++) {
                int bcnt = 0;
                for(int j=0; j<4; j++) {
                    if(blue[j][i] == 1) bcnt++;
                }
                if(bcnt == 4) {
                    delete('b', i);
                    score++;
                }
            }

            for(int i=0; i<6; i++) {
                int gcnt = 0;
                for(int j=0; j<4; j++) {
                    if(green[i][j] == 1) gcnt++;
                }
                if(gcnt == 4) {
                    delete('g', i);
                    score++;
                }
            }

            for(int i=0; i<2; i++) for(int j=0; j<4; j++) {
                if(blue[j][i] == 1) {
                    delete('b', 5);
                    break;
                }
            }

            for(int i=0; i<2; i++) for(int j=0; j<4; j++) {
                if(green[i][j] == 1) {
                    delete('g', 5);
                    break;
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<6; i++) for(int j=0; j<4; j++) {
            if(blue[j][i] == 1) cnt++;
            if(green[i][j] == 1) cnt++;
        }

        bw.write(score+"\n"+cnt+"");
    }

    private static void dropBlue(int t, int x) {
        int y = 0;
        if(t == 1 || t == 2) {
            for(int i=0; i<6; i++) {
                if(blue[x][i] == 1) break;
                y++;
            }
            y--;
            if(t == 2) blue[x][y-1] = 1;
            blue[x][y] = 1;
        }
        else {
            for(int i=0; i<6; i++) {
                if(blue[x][i] == 1 || blue[x+1][i] == 1) break;
                y++;
            }
            y--;
            blue[x][y] = 1; blue[x+1][y] = 1;
        }
    }

    private static void dropGreen(int t, int y) {
        int x = 0;
        if(t == 1 || t == 3) {
            for(int i=0; i<6; i++) {
                if(green[i][y] == 1) break;
                x++;
            }
            x--;
            if(t == 3) green[x-1][y] = 1;
            green[x][y] = 1;
        }
        else {
            for(int i=0; i<6; i++) {
                if(green[i][y] == 1 || green[i][y+1] == 1) break;
                x++;
            }
            x--;
            green[x][y] = 1; green[x][y+1] = 1;
        }
    }

    private static void delete(char c, int idx) {
        if(c == 'b') {
            for(int i=idx; i>=0; i--) {
                if(i == 0) {
                    for(int j=0; j<4; j++) blue[j][i] = 0;
                }
                else {
                    for(int j=0; j<4; j++) blue[j][i] = blue[j][i-1];
                }
            }
        }
        else if(c == 'g') {
            for(int i=idx; i>=0; i--) {
                if(i == 0) {
                    for(int j=0; j<4; j++) green[i][j] = 0;
                }
                else {
                    for(int j=0; j<4; j++) green[i][j] = green[i-1][j];
                }
            }
        }
    }

}
