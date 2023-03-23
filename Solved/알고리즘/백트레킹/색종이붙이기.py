import math

papers = [5, 5, 5, 5, 5]


def back_tracking(temp, depth, arr):
    if depth >= answer[0]:
        return
    flag = 1
    for i in range(10):
        for j in range(10):
            if arr[i][j] == 1:
                flag = 0
                break
    if flag:
        answer[0] = depth
        return
    if temp >= 100:
        return
    x = temp // 10
    y = temp % 10
    if arr[x][y] != 1:
        back_tracking(temp + 1, depth, arr)
    for p in range(5):
        if not papers[p]:
            continue
        if p + 1 + x <= 10 and p + 1 + y <= 10:
            possible = 1
            for i in range(x, x + 1 + p):
                for j in range(y, y + 1 + p):
                    if arr[i][j] != 1:
                        possible = 0
            for i in range(x, x + 1 + p):
                for j in range(y, y + 1 + p):
                    if arr[i][j] == 2:
                        possible = 0
            if not possible:
                continue
            cp = []
            for i in range(10):
                cp.append(arr[i].copy())
            for i in range(x, x + 1 + p):
                for j in range(y, y + 1 + p):
                    cp[i][j] = 2
            papers[p] -= 1
            back_tracking(temp + 1, depth + 1, cp)
            papers[p] += 1


if __name__ == "__main__":
    answer = [math.inf]
    arr = []
    for i in range(10):
        arr.append(list(map(int, input().split())))
    back_tracking(0, 0, arr)
    if answer[0] == math.inf:
        print(-1)
    else:
        print(answer[0])
