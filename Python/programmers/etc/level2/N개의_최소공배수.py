def gcd(a,b):
    while b:
        a, b = b, a%b
    return a

def solution(arr):
    ret = 1
    for i in arr:
        ret = ret*i//gcd(ret,i)
    return ret


arr = [2,6,8,14]
print(solution(arr)) # 168

arr = [1,2,3]
print(solution(arr)) # 6
