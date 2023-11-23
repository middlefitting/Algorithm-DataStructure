from collections import deque

mv = [[-1, 0], [0, -1], [1, 0], [0, 1]]


def get_min_max_count(arr):
    min_count, max_count = 0, 0
    min_value, max_value = min(arr), max(arr)
    for i in arr:
        if i == min_value:
            min_count += 1
            continue
        if i == max_value:
            max_count += 1
    return [min_count, max_count]


def impossible(ax, ay):
    if max(ax) - min(ax) == 3:
        min_count, max_count = get_min_max_count(ay)
        if min_count * max_count in [3, 6]:
            return True
    else:
        min_count, max_count = get_min_max_count(ax)
        if min_count * max_count in [3, 6]:
            return True
    return False

def start_point(arr):
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
    return start


def bfs(arr):
    start = start_point(arr)
    v = [[False] * 6 for _ in range(6)]
    v[start[0]][start[1]] = True
    queue = deque([start])
    ax, ay = [], []
    while queue:
        x, y = queue.popleft()
        ax.append(x)
        ay.append(y)
        for mx, my in mv:
            tx, ty = x + mx, y + my
            if 0 <= tx < 6 and 0 <= ty < 6 and (not v[tx][ty]) and arr[tx][ty]:
                v[tx][ty] = True
                queue.append([tx, ty])
    return [ax, ay]


def is_square(arr):
    ax, ay = bfs(arr)
    if len(ax) != 6:
        return False
    result = (1 + max(ax) - min(ax)) * (1 + max(ay) - min(ay))
    if result == 12:
        if impossible(ax, ay):
            return False
        min_count, max_count = get_min_max_count(ax)
        if min_count == 4 or max_count == 4:
            return False
        min_count, max_count = get_min_max_count(ay)
        if min_count == 4 or max_count == 4:
            return False
        return True
    if result == 10:
        min_count, max_count = get_min_max_count(ax)
        if min_count == 3 and max_count == 3:
            return True
        min_count, max_count = get_min_max_count(ay)
        if min_count == 3 and max_count == 3:
            return True
    return False


for _ in range(3):
    arr = [list(map(int, input().split())) for __ in range(6)]
    if is_square(arr):
        print("yes")
    else:
        print("no")


# from collections import deque
#
# mv = [[-1, 0], [0, -1], [1, 0], [0, 1]]
#
#
# def impossible(ax, ay):
#     if max(ax) - min(ax) == 3:
#         temp = 0
#         temp2 = 0
#         for i in ay:
#             if i == max(ay):
#                 temp += 1
#             if i == min(ay):
#                 temp2 += 1
#         if temp * temp2 in [3, 6]:
#             return True
#     else:
#         temp = 0
#         temp2 = 0
#         for i in ax:
#             if i == max(ax):
#                 temp += 1
#             if i == min(ax):
#                 temp2 += 1
#         if temp * temp2 in [3, 6]:
#             return True
#     return False
#
#
# def is_square(arr):
#     flag = False
#     start = [0, 0]
#     for i in range(6):
#         for j in range(6):
#             if arr[i][j]:
#                 start = [i, j]
#                 flag = True
#                 break
#         if flag:
#             break
#     v = [[False] * 6 for _ in range(6)]
#     v[start[0]][start[1]] = True
#     queue = deque([start])
#     ax = []
#     ay = []
#     while queue:
#         x, y = queue.popleft()
#         ax.append(x)
#         ay.append(y)
#         for mx, my in mv:
#             tx, ty = x + mx, y + my
#             if 0 <= tx < 6 and 0 <= ty < 6 and (not v[tx][ty]) and arr[tx][ty]:
#                 v[tx][ty] = True
#                 queue.append([tx, ty])
#     if len(ax) != 6:
#         return False
#     result = (1 + max(ax) - min(ax)) * (1 + max(ay) - min(ay))
#     if result == 12:
#         if impossible(ax, ay):
#             return False
#         temp = 0
#         temp2 = 0
#         for i in ax:
#             if i == max(ax):
#                 temp += 1
#             if i == min(ax):
#                 temp2 += 1
#         if temp == 4 or temp2 == 4:
#             return False
#         temp = 0
#         temp2 = 0
#         for i in ay:
#             if i == max(ay):
#                 temp += 1
#             if i == min(ay):
#                 temp2 += 1
#         if temp == 4 or temp2 == 4:
#             return False
#         return True
#     if result == 10:
#         temp = 0
#         temp2 = 0
#         for i in ax:
#             if i == max(ax):
#                 temp += 1
#             if i == min(ax):
#                 temp2 += 1
#         if temp == 3 and temp2 == 3:
#             return True
#         temp = 0
#         temp2 = 0
#         for i in ay:
#             if i == max(ay):
#                 temp += 1
#             if i == min(ay):
#                 temp2 += 1
#         if temp == 3 and temp2 == 3:
#             return True
#     return False
#
#
# for _ in range(3):
#     arr = [list(map(int, input().split())) for __ in range(6)]
#     if is_square(arr):
#         print("yes")
#     else:
#         print("no")
