package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj16939 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int cube[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int[] CUBE = new int[25];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<25; i++) CUBE[i] = Integer.parseInt(st.nextToken());

        boolean ret = false;

        if(!ret) {
            cube = CUBE.clone();
            pitchCCW(2);
            ret = chk();
        }

        if(!ret) {
            cube = CUBE.clone();
            pitchCW(2);
            ret = chk();
        }

        if(!ret) {
            cube = CUBE.clone();
            rollCCW(2);
            ret = chk();
        }

        if(!ret) {
            cube = CUBE.clone();
            rollCW(2);
            ret = chk();
        }

        if(!ret) {
            cube = CUBE.clone();
            yawCCW(2);
            ret = chk();
        }

        if(!ret) {
            cube = CUBE.clone();
            yawCW(2);
            ret = chk();
        }

        bw.write((ret) ? "1" : "0");
    }

    private static void pitchCCW(int sz) {
        int tmp1 = cube[22], tmp2 = cube[22+sz];
        cube[22] = cube[9];
        cube[22+sz] = cube[9+sz];
        cube[9] = cube[5];
        cube[9+sz] = cube[5+sz];
        cube[5] = cube[1];
        cube[5+sz] = cube[1+sz];
        cube[1] = tmp1;
        cube[1+sz] = tmp2;
    }

    private static void pitchCW(int sz) {
        for(int i=0; i<3; i++) pitchCCW(sz);
    }

    private static void rollCCW(int sz) {
        int tmp1 = cube[17], tmp2 = cube[17+sz];
        cube[17] = cube[10];
        cube[17+sz] = cube[9];
        cube[10] = cube[16];
        cube[9] = cube[16-sz];
        cube[16] = cube[3];
        cube[16-sz] = cube[4];
        cube[3] = tmp1;
        cube[4] = tmp2;
    }

    private static void rollCW(int sz) {
        for(int i=0; i<3; i++) rollCCW(sz);
    }

    private static void yawCCW(int sz) {
        int[] tmp = new int[sz];
        for(int i=0; i<sz; i++) tmp[i] = cube[21+i];
        for(int i=0; i<sz; i++) cube[21+i] = cube[17+i];
        for(int i=0; i<sz; i++) cube[17+i] = cube[5+i];
        for(int i=0; i<sz; i++) cube[5+i] = cube[13+i];
        for(int i=0; i<sz; i++) cube[13+i] = tmp[i];
    }

    private static void yawCW(int sz) {
        for (int i = 0; i < 3; i++) yawCCW(sz);
    }

    private static boolean chk() {
        for(int i=0; i<6; i++) for(int j=1; j<4; j++) {
            if (cube[4*i+j] != cube[4*i+(j+1)]) return false;
        }
        return true;
    }

}
