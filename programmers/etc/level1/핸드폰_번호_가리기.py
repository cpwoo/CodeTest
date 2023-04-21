def solution(phone_number):
    return "*"*(len(phone_number)-4) + phone_number[-4:]


phone_number = "01033334444"
print(solution(phone_number)) # "*******4444"

phone_number = "027778888"
print(solution(phone_number)) # "*****8888"
