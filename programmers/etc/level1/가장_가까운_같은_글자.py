def solution(s):
    answer = []
    d = {}
    for idx, w in enumerate(s):
        if w not in d:
            answer.append(-1)
            d[w] = idx
        else:
            answer.append(idx-d[w])
            d[w] = idx
    return answer


s = "banana"
print(solution(s)) # [-1, -1, -1, 2, 2, 2]

s = "foobar"
print(solution(s)) # [-1, -1, 1, -1, -1, -1]
