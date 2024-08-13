package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj7869 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double r2 = Double.parseDouble(st.nextToken());
        
        double d = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        
        double ret;

        if(Math.round(d) == 0) {
            ret = Math.min(Math.PI*r1*r1, Math.PI*r2*r2);
        }
        else if(d > r1+r2) {
            ret = 0.0;
        }
        else if(d <= Math.abs(r1-r2) && r1 < r2) {
            ret = Math.PI*r1*r1;
        }
        else if(d <= Math.abs(r1-r2) && r1 > r2) {
            ret = Math.PI*r2*r2;
        }
        else {
            double theta1 = Math.acos((r1*r1+d*d-r2*r2)/(2*r1*d))*2;
            double theta2 = Math.acos((r2*r2+d*d-r1*r1)/(2*r2*d))*2;
            ret = 0.5*(r1*r1*(theta1-Math.sin(theta1))+r2*r2*(theta2-Math.sin(theta2)));
        }

        bw.write(String.format("%.3f", ret));
    }

}
