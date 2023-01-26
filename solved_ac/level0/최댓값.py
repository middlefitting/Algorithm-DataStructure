arr = [list(map(int, input().split())) for _ in range(9)]
answer = [-1, -1, -1]
for i in range(9):
    for j in range(9):
        if arr[i][j] > answer[0]:
            answer = [arr[i][j], i + 1, j + 1]
print(answer[0])
print(answer[1], answer[2])