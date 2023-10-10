def solution(n):
    answer = []
    # 시작, 보조, 끝
    def dfs(n, fr, aux, to):
        if n == 1:
            answer.append([fr, to])
            return
        # (n-1)개 보조 기둥으로 이동
        dfs(n-1, fr, to, aux)
        # 가장 큰 거 끝으로 옮기고
        answer.append([fr, to])
        # (n-1)개 끝으로 이동하면 끝
        dfs(n-1, aux, fr, to)
    
    dfs(n, 1, 2, 3)
    
    return answer


n = 2
print(solution(n)) # [[1,2], [1,3], [2,3]]
