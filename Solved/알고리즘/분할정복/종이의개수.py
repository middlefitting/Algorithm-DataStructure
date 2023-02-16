import sys

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
s_minus = [0]
s_zero = [0]
s_plus = [0]


def div_and_conquer(tx, ty, temp):
    s = 0
    possible = True
    pre = 0
    for i in range(tx, tx + temp):
        for j in range(ty, ty + temp):
            s += arr[i][j]
            if i == tx and j == ty:
                pre = arr[i][j]
                continue
            elif arr[i][j] != pre:
                possible = False
            pre = arr[i][j]

    if possible and s == 0:
        s_zero[0] += 1
        return
    if s == temp ** 2:
        s_plus[0] += 1
        return
    if s == -(temp ** 2):
        s_minus[0] += 1
        return
    for i in range(3):
        for j in range(3):
            div_and_conquer(tx + (temp // 3) * i, ty + (temp // 3) * j, temp // 3)


div_and_conquer(0, 0, N)
print(s_minus[0])
print(s_zero[0])
print(s_plus[0])
