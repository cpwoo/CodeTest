package CodeTest.Java.programmers.etc.level1;

public class 평균구하기 {
    public double solution(int[] arr) {
        int n = arr.length;
        int tmp = 0;
        for (int a : arr) tmp += a;
        return (double) tmp/n;
    }
}
