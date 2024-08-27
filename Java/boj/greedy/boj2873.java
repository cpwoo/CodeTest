package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

// String 의 repeat 메소드는 Java 11부터 추가되므로 Java 11로 제출

public class boj2873 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[][] ground = new int[r][c];
        for (int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<c; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sb = new StringBuilder();

        if (r%2 == 1) {
            for (int i=0; i<r; i++) {
                if (i%2 == 0) {
                    sb.append("R".repeat(c-1));
                } else {
                    sb.append("L".repeat(c-1));
                }
                if (i != r-1) sb.append("D");
            }
        } else if (c%2 == 1) {
            for (int i=0; i<c; i++) {
                if (i%2 == 0) {
                    sb.append("D".repeat(r-1));
                } else {
                    sb.append("U".repeat(r-1));
                }
                if (i != c-1) sb.append("R");
            }
        } else {
            int low = 1000;
            int[] position = new int[2];
            Arrays.fill(position, -1);

            for (int i=0; i<r; i++) {
                for (int j=(i%2 == 0) ? 1 : 0; j<c; j+=2) {
                    if (ground[i][j] < low) {
                        low = ground[i][j];
                        position[0] = i;
                        position[1] = j;
                    }
                }
            }

            for (int i=0; i<position[1]/2; i++) {
                sb.append("D".repeat(r-1)).append("R").append("U".repeat(r-1)).append("R");
            }

            int x = 2*(position[1]/2), y = 0, xbound = x+1;

            while (x != xbound || y != r-1) {
                if (x < xbound && (y != position[0] || xbound != position[1])) {
                    x++;
                    sb.append("R");
                } else if (x == xbound && (y != position[0] || xbound-1 != position[1])) {
                    x--;
                    sb.append("L");
                }
                if (y != r-1) {
                    y++;
                    sb.append("D");
                }
            }

            for (int i=position[1]/2+1; i<c/2; i++) {
                sb.append("R").append("U".repeat(r-1)).append("R").append("D".repeat(r-1));
            }
        }

        bw.write(sb.toString());
    }
}
