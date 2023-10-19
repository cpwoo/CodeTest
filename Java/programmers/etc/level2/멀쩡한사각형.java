package CodeTest.Java.programmers.etc.level2;

public class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long total = (long) w*h;
        int g = gcd(w,h);
        w /= g; h /= g;
        int cut = w+h-1;
        return total - (long) g*cut;
    }

    private static int gcd(int w, int h) {
        while (h != 0) {
            int tmp = w;
            w = h; h = tmp%h;
        }
        return w;
    }
}
