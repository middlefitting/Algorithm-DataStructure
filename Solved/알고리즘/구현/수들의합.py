N = int(input())
answer = 0
s = 0
temp = 1
while True:
    if s + temp <= N:
        answer += 1
        s += temp
        temp += 1
    else:
        break
print(answer)
