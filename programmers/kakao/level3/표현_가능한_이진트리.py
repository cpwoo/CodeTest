from math import log2

def solution(numbers):
    answer = []
    
    def dfs(x, parent):
        if parent == "0":
            if not all(child == "0" for child in x):
                return False
        if len(x) == 1:
            return True
        mid = len(x)>>1
        return dfs(x[:mid], x[mid]) and dfs(x[mid+1:], x[mid])
                
    for num in numbers:
        num2 = bin(num)[2:]
        h = int(log2(len(num2)))+1
        L = pow(2, h)-1
        num2 = "0"*(L-len(num2)) + num2
        answer.append(1 if dfs(num2, num2[L//2]) else 0)

    return answer


numbers = [7, 42, 5]
print(solution(numbers)) # [1, 1, 0]

numbers = [63, 111, 85]
print(solution(numbers)) # [1, 1, 0]
