def solution(expression):
    operations = [('+','-','*'),('+','*','-'),('-','+','*'),('-','*','+'),('*','+','-'),('*','-','+')]
    answer = []
    for op in operations:
        a, b = op[0], op[1]
        tmp_list = []
        for e in expression.split(a):
            tmp = [f"({i})" for i in e.split(b)]
            tmp_list.append(f'({b.join(tmp)})')
        answer.append(abs(eval(a.join(tmp_list))))
    return max(answer)


expression = "100-200*300-500+20"
print(solution(expression)) # 60420

expression = "50*6-3*2"
print(solution(expression)) # 300
