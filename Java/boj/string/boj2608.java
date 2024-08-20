package CodeTest.Java.boj.string;

import java.io.*;

public class boj2608 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static String[] order = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private static int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final int L = order.length;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String a = br.readLine(), b = br.readLine();

        int ret = getInt(a)+getInt(b);
        bw.write(ret+"\n");
        bw.write(getStr(ret));
    }

    private static int getInt(String str) {
        int val = 0;

        for(int i=L-1; i>=0; i--) {
            if((str.charAt(0)+"").equals(order[i])) {
                val += value[i];
                str = str.substring(1);
                i++;
            }
            else if(str.length() > 1 && (str.charAt(0)+""+str.charAt(1)).equals(order[i])) {
                val += value[i];
                str = str.substring(2);
            }
            if(str.length() == 0) break;
        }

        return val;
    }

    private static String getStr(int val) {
        sb = new StringBuilder();
        for(int i=L-1; i>=0; i--) {
            if(val >= value[i]) {
                sb.append(order[i]);
                val -= value[i];
                i++;
            }
        }
        return sb.toString();
    }

}
