def solution(n):
    return int("".join(sorted([i for i in str(n)], reverse=True)))


n = 118372
print(solution(n)) # 873211
