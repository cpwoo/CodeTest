package CodeTest.Java.boj.impl;

import java.io.*;

public class boj7682 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static char[] arr;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        while(true) {
            String inp = br.readLine();
            if(inp.equals("end")) break;
            solve(inp);
        }
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }

    private static void solve(String str) throws Exception {
        arr = str.toCharArray();
        int cntX = 0, cntO = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 'X') cntX++;
            else if(arr[i] == 'O') cntO++;
        }

        boolean flagX = win('X'), flagO = win('O');

        if(flagX && flagO) sb.append("invalid\n");

        else if(flagX) sb.append((cntX == cntO+1) ? "valid\n" : "invalid\n");
        
        else if(flagO) sb.append((cntX == cntO) ? "valid\n" : "invalid\n");

        else sb.append((cntX == 5 && cntO == 4) ? "valid\n" : "invalid\n");
    }

    private static boolean win(char a) {
        for(int i=0; i<3; i++) {
            if(arr[i] == arr[i+3] && arr[i+3] == arr[i+6] && arr[i+6] == a) return true;
            
            if(arr[3*i] == arr[3*i+1] && arr[3*i+1] == arr[3*i+2] && arr[3*i+2] == a) return true;
        }

        if(arr[0] == arr[4] && arr[4] == arr[8] && arr[8] == a) return true;
        
        if(arr[2] == arr[4] && arr[4] == arr[6] && arr[6] == a) return true;
        
        return false;
    }

}
