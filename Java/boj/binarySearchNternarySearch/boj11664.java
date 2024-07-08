package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

class Point {
    double x, y, z;
    Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class boj11664 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static Point A, B, C;
    private static double ans;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++) {
            double nx = 0;
            double ny = 0;
            double nz = 0;
            for(int j=0; j<3; j++) {
                if(j==0) nx = Double.parseDouble(st.nextToken());
                else if(j==1) ny = Double.parseDouble(st.nextToken());
                else nz = Double.parseDouble(st.nextToken());
            }
            if(i==0) A = new Point(nx, ny, nz);
            else if(i==1) B = new Point(nx, ny, nz);
            else C = new Point(nx, ny, nz);
        }
        
        while(true) {
            double CA = Math.sqrt(Math.pow(C.x-A.x,2)+Math.pow(C.y-A.y,2)+Math.pow(C.z-A.z,2));
            double CB = Math.sqrt(Math.pow(C.x-B.x,2)+Math.pow(C.y-B.y,2)+Math.pow(C.z-B.z,2));
            
            Point mid = new Point((A.x+B.x)/2, (A.y+B.y)/2, (A.z+B.z)/2);

            if(Math.abs(CA-CB) <= 0.000001) {
                ans = Math.sqrt(Math.pow(C.x-mid.x,2)+Math.pow(C.y-mid.y,2)+Math.pow(C.z-mid.z,2));
                break;
            }
            if(CA <= CB) {
                B = mid;
            } else {
                A = mid;
            }
        }
        
        bw.write(Math.floor(ans*10000000000.0)/10000000000.0+"");
    }
}
