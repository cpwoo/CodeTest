from math import factorial

def solution(n, k):
    answer = []
    num = list(range(1, n+1))
    while n:
        idx = (k-1)//factorial(n-1)
        answer.append(num.pop(idx))
        k = k%factorial(n-1)
        n -= 1
    return answer


n, k = 3, 5
print(solution(n, k)) # [3,1,2]
