N = list(map(int, input().split()))
answer = 0
for i in N:
    if i > 0:
        answer += 1
print(answer)