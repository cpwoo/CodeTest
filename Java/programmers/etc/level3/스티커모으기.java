package CodeTest.Java.programmers.etc.level3;

public class 스티커모으기 {
    public int solution(int[] sticker) {
        int n = sticker.length;
        
        if (n == 1) return sticker[0];
        if (n == 2) return Math.max(sticker[0], sticker[1]);
        
        int[] d1 = new int[n];
        int[] d2 = new int[n];
        
        d1[0] = sticker[0]; d1[1] = d1[0];
        for (int i=2; i<n-1; i++) {
            d1[i] = Math.max(d1[i-2]+sticker[i], d1[i-1]);
        }
        
        d2[0] = 0; d2[1] = sticker[1];
        for (int i=2; i<n; i++) {
            d2[i] = Math.max(d2[i-2]+sticker[i], d2[i-1]);
        }
        
        return Math.max(d1[n-2], d2[n-1]);
    }
}
