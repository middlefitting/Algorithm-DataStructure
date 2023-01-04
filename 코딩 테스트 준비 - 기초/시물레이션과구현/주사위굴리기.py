dice = dict()
dice["top"] = 0
dice["bottom"] = 0
dice["right"] = 0
dice["left"] = 0
dice["up"] = 0
dice["down"] = 0

N, M, tx, ty, K = map(int, input().split())
arr = []
for i in range(N):
    arr.append([])
    temp = list(map(int, input().split()))
    for j in range(M):
        arr[i].append(temp[j])
orders = list(map(int, input().split()))


def east():
    temp1 = dice["top"]
    temp2 = dice["right"]
    temp3 = dice["bottom"]
    temp4 = dice["left"]
    dice["right"] = temp1
    dice["bottom"] = temp2
    dice["left"] = temp3
    dice["top"] = temp4


def west():
    temp1 = dice["top"]
    temp2 = dice["left"]
    temp3 = dice["bottom"]
    temp4 = dice["right"]
    dice["left"] = temp1
    dice["bottom"] = temp2
    dice["right"] = temp3
    dice["top"] = temp4


def north():
    temp1 = dice["top"]
    temp2 = dice["up"]
    temp3 = dice["bottom"]
    temp4 = dice["down"]
    dice["up"] = temp1
    dice["bottom"] = temp2
    dice["down"] = temp3
    dice["top"] = temp4


def south():
    temp1 = dice["top"]
    temp2 = dice["down"]
    temp3 = dice["bottom"]
    temp4 = dice["up"]
    dice["down"] = temp1
    dice["bottom"] = temp2
    dice["up"] = temp3
    dice["top"] = temp4


def copy_dice(x, y):
    if arr[x][y] == 0:
        arr[x][y] = dice["bottom"]
    # 대압 연산자 에러에 대해 고려하라......
    else:
        dice["bottom"] = arr[x][y]
        arr[x][y] = 0
    print(dice["top"])


for i in range(K):
    order = orders[i]
    if order == 1:
        if ty < M - 1:
            east()
            ty += 1
            copy_dice(tx, ty)
    if order == 2:
        if ty > 0:
            west()
            ty -= 1
            copy_dice(tx, ty)
    if order == 3:
        if tx > 0:
            north()
            tx -= 1
            copy_dice(tx, ty)
    if order == 4:
        if tx < N - 1:
            south()
            tx += 1
            copy_dice(tx, ty)

