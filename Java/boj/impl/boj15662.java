package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj15662 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N;
    private static Deque<Integer>[] t; 

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        
        t = new ArrayDeque[N];
        for (int i=0; i<N; i++) {
            t[i] = new ArrayDeque<>();
            for (char c : br.readLine().toCharArray()) {
                t[i].add(c-'0');
            }
        }

        int tc = Integer.parseInt(br.readLine()); 

        while(tc-- > 0) solve();

        int ret = 0;

        for(int i=0; i<N; i++) {
            if(t[i].peekFirst() == 1) {
                ret++;
            }
        }

        bw.write(ret+"");
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken())-1; 
        int d = Integer.parseInt(st.nextToken()); 

        int[] direction = new int[N];
        direction[n] = d;

        for(int i=n; i>0; i--) {
            if (getNthElement(t[i], 6) != getNthElement(t[i-1], 2)) direction[i-1] = -direction[i];
            else break;
        }

        for(int i=n; i<N-1; i++) {
            if (getNthElement(t[i], 2) != getNthElement(t[i+1], 6)) direction[i+1] = -direction[i];
            else break;
        }

        for (int i=0; i<N; i++) {
            if (direction[i] == 1) t[i].addFirst(t[i].pollLast()); 
            else if (direction[i] == -1) t[i].addLast(t[i].pollFirst());
        }
    }

    private static int getNthElement(Deque<Integer> deque, int n) {
        Iterator<Integer> it = deque.iterator();
        for (int i=0; i<n; i++) it.next();
        return it.next();
    }

}
