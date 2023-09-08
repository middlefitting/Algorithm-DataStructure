N = int(input())
answer = ((N - 1) * 8)
answer += sum(list(map(int, input().split())))
print(answer // 24, end=" ")
print(answer % 24)

