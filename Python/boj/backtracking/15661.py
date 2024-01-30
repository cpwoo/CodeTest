from itertools import combinations

n = int(input())
arr = list(list(map(int, input().split())) for _ in range(n))

row = [sum(i) for i in arr]
col = [sum(i) for i in zip(*arr)]
new_arr = [i+j for i,j in zip(row, col)]
total_sum = sum(new_arr)//2
result = int(1e9)

for num in range(1, n//2+1):
    for comb in combinations(new_arr, num):
        result = min(result, abs(total_sum-sum(comb)))
        if not result:
            break
    if not result:
        break

print(result)
