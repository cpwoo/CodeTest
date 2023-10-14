package CodeTest.Java.programmers.etc.level1;

public class 하샤드수 {
    public boolean solution(int x) {
        int tmp = 0;

        for (String i : String.valueOf(x).split("")) {
            tmp += Integer.parseInt(i);
        }
        
        return x%tmp == 0;
    }
}
