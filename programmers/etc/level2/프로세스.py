from collections import deque

def solution(priorities, location):
    answer = []
    q = deque([idx, priority] for idx, priority in enumerate(priorities))
    
    while q:
        idx, priority = q.popleft()
        if q and priority < max([i[1] for i in q]):
            q.append([idx, priority])
        else:
            answer.append(idx)
            
    return answer.index(location)+1


priorities = [2, 1, 3, 2]
location = 2
print(solution(priorities, location)) # 1

priorities = [1, 1, 9, 1, 1, 1]
location = 0
print(solution(priorities, location)) # 5
