package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj3101 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    
    private static int n;
    private static long diagonal, y;

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
        st.nextToken();

        char[] commands = br.readLine().toCharArray();
       
        diagonal = 1; y = 0;

        long ret = 1;

        for(char command : commands) {
            switch(command) {
                case('U'): {
                    diagonal--; y--; break;
                }
                case('D'): {
                    diagonal++; y++; break;
                }
                case('L'): {
                    diagonal--; break;
                }
                case('R'): {
                    diagonal++; break;
                }
            }
            ret += find();
        }

        bw.write(ret+"");
    }

    private static long find() {
        if(diagonal%2 == 0) {
            if(diagonal > n) return (diagonal*(diagonal-1)/2)+y-((diagonal-n)*(diagonal-n));
            return (diagonal*(diagonal-1)/2)+y;
        }
        else {
            if(diagonal > n) return (diagonal*(diagonal+1)/2)-(y-1)-((diagonal-n)*(diagonal-n));
            return (diagonal*(diagonal+1)/2)-(y-1);
        }
    }

}
