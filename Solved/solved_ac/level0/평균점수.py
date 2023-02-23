answer = 0
for _ in range(5):
    temp = int(input())
    if temp > 40:
        answer += temp
    else:
        answer += 40
print(answer // 5)
