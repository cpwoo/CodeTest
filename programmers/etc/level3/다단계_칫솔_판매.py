def solution(enroll, referral, seller, amount):
    graph, ans = {}, {e:0 for e in enroll}

    for e, r in zip(enroll, referral):
        graph[e] = r

    for s, a in zip(seller, amount):
        money = a*100
        rate = money//10
        ans[s] += money-rate
        x = graph[s]

        while x != "-":
            if rate == 0: 
                break
            ans[x] += rate - rate//10
            rate //= 10
            x = graph[x]

    return list(ans.values())


enroll = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
referral = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
seller = ["young", "john", "tod", "emily", "mary"]
amount = [12, 4, 2, 5, 10]
print(solution(enroll, referral, seller, amount)) # [360, 958, 108, 0, 450, 18, 180, 1080]

enroll = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
referral = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
seller = ["sam", "emily", "jaimie", "edward"]
amount = [2, 3, 5, 4]
print(solution(enroll, referral, seller, amount)) # [0, 110, 378, 180, 270, 450, 0, 0]
