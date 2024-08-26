package CodeTest.Java.boj.greedy;

import java.io.*;

public class boj2590 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int one = Integer.parseInt(br.readLine());
        int two = Integer.parseInt(br.readLine());
        int three = Integer.parseInt(br.readLine());
        int four = Integer.parseInt(br.readLine());
        int five = Integer.parseInt(br.readLine());
        int six = Integer.parseInt(br.readLine());

        int ret = six;

        ret += five;
        one = Math.max(0, one-five*11);

        int area;
        while(four != 0) {
            area = 36-4*4;
            area -= Math.min(5, two)*4;
            four--;
            two = Math.max(0, two-5);
            one = Math.max(0, one-area);
            ret++;
        }

        while(three != 0) {
            area = 36-9*Math.min(4, three);

            if(three >= 4) {
                three -= 4;
                area = 0;
            }
            else if(three == 3) {
                three = 0;
                area -= Math.min(1, two)*4;
                two = Math.max(0, two-1);
            }
            else if(three == 2) {
                three = 0;
                area -= Math.min(3, two)*4;
                two = Math.max(0, two-3);
            }
            else {
                three = 0;
                area -= Math.min(5, two)*4;
                two = Math.max(0, two-5);
            }

            one = Math.max(0, one-area);
            ret++;
        }

        while(two != 0) {
            area = 36-4*Math.min(9, two);
            two = Math.max(0, two-9);
            one = Math.max(0, one-area);
            ret++;
        }

        while(one != 0) {
            one = Math.max(0, one-36);
            ret++;
        }

        bw.write(ret+"");
    }

}
