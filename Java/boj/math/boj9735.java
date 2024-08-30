package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj9735 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        double x = 0;
        for(int i=1; i<Math.abs(d)+1; i++) {
            if(a*i*i*i+b*i*i+c*i+d == 0) {
                x = i;
                break;
            }
            if(-a*i*i*i+b*i*i-c*i+d == 0) {
                x = -i;
                break;
            }
        }

        long p = a;
        long q = (long) (a*x+b);
        long r = (long) (a*x*x+b*x+c);

        Set<Double> set = new TreeSet<>();
        set.add(x);

        long Det = q*q-4*p*r;

        if(Det > 0) {
            set.add((-q+Math.sqrt(Det))/(2.0*p));
            set.add((-q-Math.sqrt(Det))/(2.0*p));            
        }
        else if(Det == 0) set.add(-q/(2.0*p));

        for(double s : set) sb.append(String.format("%.4f", s)).append(' ');

        sb.append('\n');
    }

}
