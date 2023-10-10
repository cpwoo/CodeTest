import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

INF = int(1e9)

def dfs(idx, sub_total):
    global answer
    
    if idx == len(op):
        answer = max(answer, int(sub_total))
        return
    
    first = str(eval(sub_total + op[idx] + nums[idx+1]))
    dfs(idx+1, first)
    
    if idx+1 < len(op):
        second = str(eval(nums[idx+1] + op[idx+1] + nums[idx+2]))
        second = str(eval(sub_total + op[idx] + second))
        dfs(idx+2, second)


n = int(input())
expression = input()
nums, op = [], []
answer = -INF

for e in expression:
    nums.append(e) if e.isdigit() else op.append(e)

dfs(0, nums[0])
print(answer)
