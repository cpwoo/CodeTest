package CodeTest.Java.boj.impl;

import java.io.*;

public class boj20164 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int minV, maxV;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();

        minV = Integer.MAX_VALUE; maxV = Integer.MIN_VALUE;
        
        dfs(n, command(n));

        bw.write(minV+" "+maxV+"");

        bw.flush();
        bw.close();
    }

    private static void dfs(String str, int oddN) {
        if(str.length() == 1) {
            minV = Math.min(minV, oddN);
            maxV = Math.max(maxV, oddN);
        }
        else if(str.length() == 2) {
            String tmp = String.valueOf((str.charAt(0)-'0')+(str.charAt(1)-'0'));
            dfs(tmp, oddN+command(tmp));
        }
        else {
            for(int i=0; i<str.length()-2; i++) {
                for(int j=i+1; j<str.length()-1; j++) {
                    int a = Integer.parseInt(str.substring(0, i+1));
                    int b = Integer.parseInt(str.substring(i+1, j+1));
                    int c = Integer.parseInt(str.substring(j+1));
                    String tmp = String.valueOf(a+b+c);
                    dfs(tmp, oddN+command(tmp));
                }
            }
        }
    }

    private static int command(String str) {
        int oddN = 0;
        for(char i : str.toCharArray()) {
            if((i-'0')%2 == 1) oddN++;
        }
        return oddN;
    }

}
