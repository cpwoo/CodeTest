package CodeTest.Java.programmers.etc.level1;

public class 부족한금액계산하기 {
    public long solution(long price, long money, long count) {
        price *= count*(count+1)/2;
        return Math.max(price-money, 0);
    }
}
