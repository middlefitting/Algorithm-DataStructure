from collections import deque

mv = [[-1, 0], [0, -1], [1, 0], [0, 1]]


def impossible(ax, ay):
    if max(ax) - min(ax) == 3:
        temp = 0
        temp2 = 0
        for i in ay:
            if i == max(ay):
                temp += 1
            if i == min(ay):
                temp2 += 1
        if temp * temp2 in [3, 6]:
            return True
    else:
        temp = 0
        temp2 = 0
        for i in ax:
            if i == max(ax):
                temp += 1
            if i == min(ax):
                temp2 += 1
        if temp * temp2 in [3, 6]:
            return True
    return False


def is_square(arr):
    flag = False
    start = [0, 0]
    for i in range(6):
        for j in range(6):
            if arr[i][j]:
                start = [i, j]
                flag = True
                break
        if flag:
            break
    v = [[False] * 6 for _ in range(6)]
    v[start[0]][start[1]] = True
    queue = deque([start])
    ax = []
    ay = []
    while queue:
        x, y = queue.popleft()
        ax.append(x)
        ay.append(y)
        for mx, my in mv:
            tx, ty = x + mx, y + my
            if 0 <= tx < 6 and 0 <= ty < 6 and (not v[tx][ty]) and arr[tx][ty]:
                v[tx][ty] = True
                queue.append([tx, ty])
    if len(ax) != 6:
        return False
    result = (1 + max(ax) - min(ax)) * (1 + max(ay) - min(ay))
    if result == 12:
        if impossible(ax, ay):
            return False
        temp = 0
        temp2 = 0
        for i in ax:
            if i == max(ax):
                temp += 1
            if i == min(ax):
                temp2 += 1
        if temp == 4 or temp2 == 4:
            return False
        temp = 0
        temp2 = 0
        for i in ay:
            if i == max(ay):
                temp += 1
            if i == min(ay):
                temp2 += 1
        if temp == 4 or temp2 == 4:
            return False
        return True
    if result == 10:
        temp = 0
        temp2 = 0
        for i in ax:
            if i == max(ax):
                temp += 1
            if i == min(ax):
                temp2 += 1
        if temp == 3 and temp2 == 3:
            return True
        temp = 0
        temp2 = 0
        for i in ay:
            if i == max(ay):
                temp += 1
            if i == min(ay):
                temp2 += 1
        if temp == 3 and temp2 == 3:
            return True
    return False


for _ in range(3):
    arr = [list(map(int, input().split())) for __ in range(6)]
    if is_square(arr):
        print("yes")
    else:
        print("no")
