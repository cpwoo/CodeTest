package CodeTest.Java.programmers.kakao.level3;

public class 미로탈출명령어 {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        if ((x+y+r+c)%2 != k%2 || Math.abs(r-x) + Math.abs(c-y) > k) return "impossible";

        StringBuilder sb = new StringBuilder();

        while (k-- > 0) {
            int downX = x+1, leftY = y-1, rightY = y+1, upX = x-1;

            if (downX <= n && Math.abs(r-downX) + Math.abs(c-y) <= k) {
                sb.append('d'); x = downX;
            }
            else if (leftY > 0 && Math.abs(r-x) + Math.abs(c-leftY) <= k) {
                sb.append('l'); y = leftY;
            }
            else if (rightY <= m && Math.abs(r-x) + Math.abs(c-rightY) <= k) {
                sb.append('r'); y = rightY;
            }
            else if (upX > 0 && Math.abs(r-upX) + Math.abs(c-y) <= k) {
                sb.append('u'); x = upX;
            }
        }

        return sb.toString();
    }
}
