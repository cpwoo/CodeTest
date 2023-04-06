def nTok(n, k):
    tmp = ""
    while n:
        tmp = str(n%k) + tmp
        n //= k
    return tmp

def isPrime(x):
    if x <= 1: return False
    i = 2
    while i*i <= x:
        if x%i == 0: return False
        i += 1
    return True

def solution(n, k):
    answer = 0
    arr = nTok(n, k).split("0")
    for a in arr:
        if not a:
            continue
        elif isPrime(int(a)):
            answer += 1
        else:
            continue
    return answer


n, k = 437674, 3
print(solution(n, k)) # 3

n, k = 110011, 10
print(solution(n, k)) # 2
