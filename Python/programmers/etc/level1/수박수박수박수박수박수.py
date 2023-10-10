def solution(n):
    return "수박"*(n>>1)+"수" if n&1 else "수박"*(n>>1)


n = 3
print(solution(n)) # "수박수"

n = 4
print(solution(n)) # "수박수박"
