answer = -1
for i in range(int(input())):
    N, M = map(int, input().split())
    if N <= M:
        if answer == -1:
            answer = M
        elif M < answer:
            answer = M
print(answer)
