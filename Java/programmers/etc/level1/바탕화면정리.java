package CodeTest.Java.programmers.etc.level1;

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int lux = 50, rdx = 0, luy = 50, rdy = 0;
        int r = wallpaper.length, c = wallpaper[0].length();

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (wallpaper[i].substring(j, j+1).equals("#")) {
                    lux = Math.min(lux, i);
                    rdx = Math.max(rdx, i+1);
                    luy = Math.min(luy, j);
                    rdy = Math.max(rdy, j+1);
                }
            }
        }

        return new int[]{lux, luy, rdx, rdy};
    }
}
