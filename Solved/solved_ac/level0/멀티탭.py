N = int(input())
answer = 0
for _ in range(N):
    temp = int(input())
    answer += temp
answer -= (N - 1)
print(answer)
