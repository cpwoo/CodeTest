package CodeTest.Java.programmers.etc.level4;

public class 도둑질 {
    public int solution(int[] money) {
        int n = money.length;

        if (n == 1) return money[0];

        int[] d1 = new int[n];
        int[] d2 = new int[n];

        d1[0] = money[0];
        d1[1] = d1[0];

        for (int i=2; i<n-1; i++) {
            d1[i] = Math.max(d1[i-2]+money[i], d1[i-1]);
        }

        d2[1] = Math.max(money[1], d2[0]);

        for (int i=2; i<n; i++) {
            d2[i] = Math.max(d2[i-2]+money[i], d2[i-1]);
        }

        return Math.max(d1[n-2], d2[n-1]);
    }
}
