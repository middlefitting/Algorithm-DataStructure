N = int(input())
answer = 0
for i in range(N):
    a, b = map(int, input().split())
    if a == 136:
        answer += 1000
    elif a == 142:
        answer += 5000
    elif a == 148:
        answer += 10000
    elif a == 154:
        answer += 50000
print(answer)
