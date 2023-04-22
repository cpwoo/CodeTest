def solution(s):
    answer = 0
    pro, con = 0, 0
    for i in s:
        if pro == con:
            answer += 1
            target = i
        if i == target:
            pro += 1
        else:
            con += 1
    return answer


s = "banana"
print(solution(s)) # 3

s = "abracadabra"
print(solution(s)) # 6

s = "aaabbaccccabba"
print(solution(s)) # 3
