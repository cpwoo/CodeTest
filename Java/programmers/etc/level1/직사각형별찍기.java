package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 직사각형별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i=0; i<b; i++) {
            StringBuilder stb = new StringBuilder();
            for (int j=0; j<a; j++) {
                stb.append("*");
            }
            System.out.println(stb.toString());
        }

        sc.close();
    }
}
