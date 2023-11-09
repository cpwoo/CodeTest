package CodeTest.Java.programmers.etc.level3;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long[] arr = new long[sequence.length+1];
        
        for (int i=0; i<sequence.length; i++) {
            arr[i+1] = i%2 == 1 ? -sequence[i] : sequence[i];
        }

        for (int i=0; i<arr.length-1; i++) {
            arr[i+1] += arr[i];
        }

        long _min = Long.MAX_VALUE, _max = Long.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            _min = Math.min(_min, arr[i]);
            _max = Math.max(_max, arr[i]);
        }

        return _max-_min;
    }
}
