package CodeTest.Java.programmers.etc.level2;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String[] answer = s.split(" ");
        int _min = Integer.MAX_VALUE, _max = Integer.MIN_VALUE;
        
        for (String a : answer) {
            int tmp = Integer.parseInt(a);
            _min = Math.min(_min, tmp);
            _max = Math.max(_max, tmp);
        }
        
        return String.valueOf(_min) + " " + String.valueOf(_max);
    }
}
