package CodeTest.Java.programmers.etc.level1;

public class 숫자문자열과영단어 {
    public int solution(String s) {
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<10; i++) {
            s = s.replaceAll(eng[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}
