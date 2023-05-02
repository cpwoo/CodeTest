def solution(n, cores):
    answer = 0
    if n <= len(cores):
        return n
    
    n -= len(cores)
    left, right = 1, max(cores)*n
    while left+1 < right:
        mid = (left+right)//2
        capacity = 0
        for c in cores:
            capacity += mid//c
        if capacity >= n:
            right = mid
        else:
            left = mid
    
    for c in cores:
        n -= (right-1)//c
    
    for i in range(len(cores)):
        if right%cores[i] == 0:
            n -= 1
            if n == 0:
                return i+1


n, cores = 6, [1,2,3]
print(solution(n, cores)) # 2
   