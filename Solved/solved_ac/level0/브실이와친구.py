N, M = map(int, input().split())
K, X = map(int, input().split())
answer = 0
for i in range(N, M + 1):
    if abs(i - K) <= X:
        answer += 1
if answer == 0:
    print("IMPOSSIBLE")
else:
    print(answer)