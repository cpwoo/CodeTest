def solution(elements):
    n = len(elements)
    answer = set()

    for i in range(n):
        tmp = elements[i]
        answer.add(tmp)
        for j in range(i+1, i+n):
            tmp += elements[j%n]
            answer.add(tmp)
    
    return len(answer)


elements = [7,9,1,1,4]
print(solution(elements)) # 18
