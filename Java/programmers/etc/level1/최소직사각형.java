package CodeTest.Java.programmers.etc.level1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int length = 0, height = 0;

        for (int[] size : sizes) {
            length = Math.max(length, Math.min(size[0], size[1]));
            height = Math.max(height, Math.max(size[0], size[1]));
        }
        
        return length*height;
    }
}
