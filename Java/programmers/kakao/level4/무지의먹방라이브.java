package CodeTest.Java.programmers.kakao.level4;

import java.util.*;

class Food implements Comparable<Food> {
    int time, idx;

    Food(int time, int idx) {
        this.time = time;
        this.idx = idx;
    }

    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

public class 무지의먹방라이브 {
    public int solution(int[] food_times, long k) {
        long _sum = 0;
        for (int food : food_times) _sum += food;
        if (_sum <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i=0; i<food_times.length; i++) {
            pq.add(new Food(food_times[i], i+1));
        }

        int n = food_times.length;
        long total = 0, previous = 0;
        while (total+((pq.peek().time-previous)*n) <= k) {
            int now = pq.poll().time;
            total += (now-previous)*n;
            n--;
            previous = now;
        }

        List<Food> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll());

        Collections.sort(res, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.idx, b.idx);
            }
        });

        return res.get((int)((k-total)%n)).idx;
    }    
}
