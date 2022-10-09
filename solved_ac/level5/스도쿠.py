import sys

arr = []

depth = 0
for i in range(9):
    arr.append([])
    temp = list(map(str, input()))
    for j in range(9):
        if int(temp[j]) == 0:
            depth += 1
        arr[i].append(int(temp[j]))


def side_check(p):
    for i in range(9):
        if p == arr[i][i]:
            print(p, arr[i][i])
            return False
    return True


def col_check(p, ind_j):
    for i in range(9):
        if arr[i][ind_j] == p:
            return False
    return True


def box_check(p, ind_i, ind_j):
    x = (ind_i // 3) * 3
    y = (ind_j // 3) * 3

    for i in range(x, x + 3):
        for j in range(y, y + 3):
            if arr[i][j] == p:
                return False
    return True


def find():
    for i in range(9):
        for j in range(9):
            if arr[i][j] == 0:
                return i, j


def sdoku(dep):
    if dep == depth:
        for i in range(9):
            for j in range(9):
                print(arr[i][j], end="")
            print()
        sys.exit()

    ind_i, ind_j = find()
    for p in range(1, 10):
        # if ind_j == ind_i and not side_check(p):
        #     continue
        if (p not in arr[ind_i]) and col_check(p, ind_j) and box_check(p, ind_i, ind_j):
            arr[ind_i][ind_j] = p
            sdoku(dep + 1)
            arr[ind_i][ind_j] = 0

sdoku(0)
