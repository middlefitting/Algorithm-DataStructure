N, M = map(int, input().split())
arr = []
for i in range(N):
    arr.append([])
    temp = list(map(int, input().split()))
    for j in range(M):
        if j == 0:
            arr[i].append(temp[j])
        else:
            arr[i].append(arr[i][-1] + temp[j])

for _ in range(int(input())):
    answer = 0
    x1, y1, x2, y2 = map(lambda x: int(x) - 1, input().split())
    for i in range(x1, x2 + 1):
        if y1 != 0:
            answer += (arr[i][y2] - arr[i][y1 - 1])
        else:
            answer += arr[i][y2]
    print(answer)
