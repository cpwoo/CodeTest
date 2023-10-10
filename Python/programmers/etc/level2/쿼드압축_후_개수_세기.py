def compress(arr, s, n):
    y, x, tg = s[0], s[1], arr[s[0]][s[1]]
    for i in range(n):
        for j in range(n):
            if arr[y+i][x+j] != tg:
                compress(arr, [y, x], n//2)
                compress(arr, [y+n//2, x], n//2)
                compress(arr, [y, x+n//2], n//2)
                compress(arr, [y+n//2, x+n//2], n//2)
                return
    answer[tg] += 1
        
def solution(arr):
    global answer
    answer = [0, 0]
    compress(arr, [0, 0], len(arr))
    return answer


arr = [[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]
print(solution(arr)) # [4,9]

arr = [[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],
       [0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],
       [0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],
       [0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]
print(solution(arr)) # [10,15]
