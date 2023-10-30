def is_bingo(bingo):
    result = 0
    for i in range(5):
        if sum(bingo[i]) == 5:
            result += 1

    for i in range(5):
        temp = 0
        for j in range(5):
            temp += bingo[j][i]
        if temp == 5:
            result += 1

    for i in range(5):
        if not bingo[i][i]:
            break
        if i == 4:
            result += 1

    for i in range(5):
        if not bingo[i][4 - i]:
            break
        if i == 4:
            result += 1

    if result >= 3:
        return True
    return False


arr = [list(map(int, input().split())) for _ in range(5)]
d = dict()
for i in range(5):
    for j in range(5):
        d[arr[i][j]] = [i, j]

bingo = [[False] * 5 for _ in range(5)]

answer = 0
for _ in range(5):
    for i in list(map(int, input().split())):
        answer += 1
        tx, ty = d[i]
        bingo[tx][ty] = True
        if is_bingo(bingo):
            print(answer)
            exit(0)

