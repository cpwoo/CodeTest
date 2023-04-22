def solution(cards1, cards2, goal):
    answer = "Yes"
    cards1 = cards1[::-1]
    cards2 = cards2[::-1]
    
    for g in goal:
        if cards1[-1:] == [g]:
            cards1.pop()
        elif cards2[-1:] == [g]:
            cards2.pop()
        else:
            answer = "No"
            break

    return answer


cards1, cards2 = ["i", "drink", "water"], ["want", "to"]
goals = ["i", "want", "to", "drink", "water"]
print(solution(cards1, cards2, goals)) # "Yes"

cards1, cards2 = ["i", "water", "drink"], ["want", "to"]
goals = ["i", "want", "to", "drink", "water"]
print(solution(cards1, cards2, goals)) # "No"
