package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridgeWeight = 0;
        
        Queue<Integer> waiting = new LinkedList<>(){};
        for (int truck : truck_weights) {
            waiting.add(truck);
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }

        while (!waiting.isEmpty() || bridgeWeight > 0) {
            bridgeWeight -= bridge.poll();

            if (!waiting.isEmpty() && bridgeWeight+waiting.peek() <= weight) {
                bridge.add(waiting.peek());
                bridgeWeight += waiting.poll();
            } else {
                bridge.add(0);
            }

            answer++;
        }

        return answer;
    }
}
