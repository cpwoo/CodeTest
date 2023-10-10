import sys
arr = [[1,1,1],[5,1,1],[25,5,1]]
res = sys.maxsize
m = dict()
m["diamond"], m["iron"], m["stone"] = 0, 1, 2

def dfs(idx, d, ir, s, minerals, p):
    global res
    if idx >= len(minerals) or not (d or ir or s):
        res = min(res, p)
        return
    
    dp, ip, sp = 0, 0, 0
    for i in range(idx, min(idx+5, len(minerals))):
        dp += arr[0][m[minerals[i]]]
        ip += arr[1][m[minerals[i]]]
        sp += arr[2][m[minerals[i]]]
    
    if d:
        dfs(idx+5, d-1, ir, s, minerals, p+dp)
    if ir:
        dfs(idx+5, d, ir-1, s, minerals, p+ip)
    if sp:
        dfs(idx+5, d, ir, s-1, minerals, p+sp)

        
def solution(picks, minerals):
    global res
    dfs(0, picks[0], picks[1], picks[2], minerals, 0)
    return res


picks = [1,3,2]
minerals = ["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]
print(solution(picks, minerals)) # 12

picks = [0,1,1]
minerals = ["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]
print(solution(picks, minerals)) # 50
