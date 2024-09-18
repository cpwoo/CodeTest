package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj2931 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int R, C;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];
        for(int i=0; i<R; i++) arr[i] = br.readLine().toCharArray();

        boolean flag = false;
        int ret = 0, cnt = 0;
        String str = "   2 |1  3- 4  +";

        for(int y=0; y<R; y++) for(int x=0; x<C; x++) {
            char c = arr[y][x];
            int up = y-1, down = y+1, left = x-1, right = x+1;

            if(c == '.') {
                cnt = 0;
                if(chk(up, x)) {
                    if("|+14".indexOf(arr[up][x]) != -1) {
                        ret++;
                        flag = true;
                        cnt++;
                    }
                }
                if(chk(down, x)) {
                    if("|+23".indexOf(arr[down][x]) != -1) {
                        ret += 4;
                        flag = true;
                        cnt++;
                    }
                }
                if(chk(y, left)) {
                    if("-+12".indexOf(arr[y][left]) != -1) {
                        ret += 8;
                        flag = true;
                        cnt++;
                    }
                }
                if(chk(y, right)) {
                    if("-+34".indexOf(arr[y][right]) != -1) {
                        ret += 2;
                        flag = true;
                        cnt++;
                    }
                }
            }

            if(flag && cnt >= 2) {
                bw.write(String.format("%d %d %c", y+1, x+1, str.charAt(ret)));
                return;
            }
            else flag = false;
        }
    }

    private static boolean chk(int y, int x) {
        return (0 <= y && y < R && 0 <= x && x < C);
    }

}
