N, K = map(int, input().split())
bags = []
## 접근은 되지만 수정이 안되는것 같다
answer= [[0] * (K + 1) for i in range(N + 1)]

for i in range(N):
    item, value = map(int, input().split())
    bags.append([item, value])


for i in range(N):
    for j in range(1, K + 1):
        weight = bags[i][0]
        value = bags[i][1]
        if j < weight:
            answer[i][j] = answer[i - 1][j]
        else:
            answer[i][j] = max(answer[i - 1][j], answer[i - 1][j - weight] + value)

print(answer[N - 1][K])

