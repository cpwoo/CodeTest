package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;

public class boj16434 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static int n, arr[][];
    private static long maxHP, curHP, atk;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String[] inp = br.readLine().split(" ");
        n = Integer.parseInt(inp[0]);
        int H = Integer.parseInt(inp[1]);

        arr = new int[n][3];
        for(int i=0; i<n; i++) {
            inp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(inp[0]);
            arr[i][1] = Integer.parseInt(inp[1]);
            arr[i][2] = Integer.parseInt(inp[2]);
        }

        long result = Long.MAX_VALUE;
        long start = 0, end = Long.MAX_VALUE, mid;
        while(start <= end) {
            mid = (start+end)/2;
            
            atk = H; maxHP = mid; curHP = mid;

            if(play()) {
                result = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        bw.write(result+"");
    }

    private static boolean play() {
        for(int i=0; i<n; i++) {
            if(arr[i][0] == 1) {
                if(!fight(arr[i][1], arr[i][2])) return false;
            } else {
                potion(arr[i][1], arr[i][2]);
            }
        }
        return true;
    }

    private static boolean fight(long a, long h) {
        long monster = h/atk + (h%atk == 0 ? 0 : 1);
        long player = curHP/a + (curHP%a == 0 ? 0 : 1);

        if(monster <= player) {
            curHP -= a*(monster-1);
            return true;
        } 
        return false;
    }

    private static void potion(int a, int h) {
        atk += a;
        curHP = Math.min(curHP+h, maxHP);
    }

}
