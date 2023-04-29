from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridgeWeight = 0
    waiting = deque(truck_weights)
    bridge = deque([0]*bridge_length)
    
    while waiting or bridgeWeight > 0:
        bridgeWeight -= bridge.popleft()
        
        if waiting and bridgeWeight+waiting[0] <= weight:
            bridge.append(waiting[0])
            bridgeWeight += waiting.popleft()
        else:
            bridge.append(0)
        
        answer += 1
        
    return answer


bridge_length, weight = 2, 10
truck_weights = [7,4,5,6]
print(solution(bridge_length, weight, truck_weights)) # 8

bridge_length, weight = 100, 100
truck_weights = [10]
print(solution(bridge_length, weight, truck_weights)) # 101

bridge_length, weight = 100, 100
truck_weights = [10,10,10,10,10,10,10,10,10,10]
print(solution(bridge_length, weight, truck_weights)) # 110
