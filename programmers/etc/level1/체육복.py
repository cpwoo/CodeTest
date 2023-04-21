def solution(n, lost, reserve):
    sr = set(reserve)-set(lost)
    sl = set(lost)-set(reserve)
    for i in sr:
        if i-1 in sl:
            sl.remove(i-1)
        elif i+1 in sl:
            sl.remove(i+1)
    return n-len(sl)


n = 5
lost, reserve = [2, 4], [1, 3, 5]
print(solution(n, lost, reserve)) # 5

n = 5
lost, reserve = [2, 4], [3]
print(solution(n, lost, reserve)) # 4

n = 3
lost, reserve = [3], [1]
print(solution(n, lost, reserve)) # 2
