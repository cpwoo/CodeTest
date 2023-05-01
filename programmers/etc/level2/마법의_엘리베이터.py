def solution(storey):
    if storey < 10 :
        return min(storey, 11-storey)
    left = storey%10
    return min(left+solution(storey//10), 10-left+solution(storey//10+1))


storey = 16
print(solution(storey)) # 6

storey = 2554
print(solution(storey)) # 16
