def solution(absolutes, signs):
    answer = 0
    for i in range(len(absolutes)):
        if signs[i]:
            answer += absolutes[i]
        else:
            answer -= absolutes[i]
    return answer


absolutes = [4,7,12]
signs = [True,False,True]
print(solution(absolutes, signs)) # 9

absolutes = [1,2,3]
signs = [False,False,True]
print(solution(absolutes, signs)) # 0
