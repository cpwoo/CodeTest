package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj2800 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        char[] line = br.readLine().toCharArray();
        Stack<Integer> stk = new Stack<>();
        int[] open = new int[10], close = new int[10];
        int num = 0;

        for(int i=0; i<line.length; i++) {
            if(line[i] == '(') stk.add(i);
            else if(line[i] == ')') {
                open[num] = stk.pop();
                close[num++] = i;
            }
        }

        TreeSet<String> tSet = new TreeSet<>();
        boolean[] chk = new boolean[line.length];
        int max = (1<<num)-1;

        for(int bit=0; bit<max+1; bit++) {
            if(bit != 0) {
                sb = new StringBuilder();
                for(int j=0; j<num; j++) {
                    if((bit&(1<<j)) > 0) {
                        chk[open[j]] = true;
                        chk[close[j]] = true;
                    }
                }
                for(int j=0; j<line.length; j++) {
                    if(chk[j]) chk[j] = false;
                    else sb.append(line[j]);
                }
                tSet.add(sb.toString());
            }
        }

        sb = new StringBuilder();
        for(String str : tSet) sb.append(str).append('\n');

        bw.write(sb.toString());
    }

}
