import re

def solution(dartResult):
    answer = []
    square = {"S":1, "D":2, "T":3}
    option = {"":1, "*":2, "#":-1}
    p = re.compile("(\d+)([SDT])([*#]?)")
    dart = p.findall(dartResult)
    for i in range(len(dart)):
        if dart[i][2] == "*" and i > 0:
            answer[-1] *= 2
        answer.append(int(dart[i][0]) ** square[dart[i][1]] * option[dart[i][2]])

    return sum(answer)


dartResult = "1S2D*3T"
print(solution(dartResult)) # 37

dartResult = "1D2S#10S"
print(solution(dartResult)) # 9

dartResult = "1D2S0T"
print(solution(dartResult)) # 3

dartResult = "1S*2T*3S"
print(solution(dartResult)) # 23

dartResult = "1D#2S*3S"
print(solution(dartResult)) # 5

dartResult = "1T2D3D#"
print(solution(dartResult)) # -4

dartResult = "1D2S3T*"
print(solution(dartResult)) # 59
