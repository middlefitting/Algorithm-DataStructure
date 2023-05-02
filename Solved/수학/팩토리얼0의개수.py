N = int(input())
answer = 0
for i in range(1, N + 1):
    if i % 5 == 0:
        temp = i
        while temp % 5 == 0:
            answer += 1
            temp //= 5
print(answer)
