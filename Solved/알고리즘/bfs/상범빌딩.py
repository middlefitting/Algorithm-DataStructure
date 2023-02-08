# 3 4 5
# S....
# .###.
# .##..
# ###.#
#
# #####
# #####
# ##.##
# ##...
#
# #####
# #####
# #.###
# ####E
#
# 1 3 3
# S##
# #E#
# ###
#
# 0 0 0
from collections import deque

while True:
    L, R, C = map(int, input().split())
    s = [[[0] * C for _ in range(R)] for _ in range(L)]
    mv = [[1, 0, 0], [-1, 0, 0], [0, 1, 0], [0, -1, 0], [0, 0, 1], [0, 0, -1]]

    if L == 0 and R == 0 and C == 0:
        break
    arr = []
    for i in range(L):
        arr.append([])
        for j in range(R):
            arr[i].append(list(str(input())))
        str(input())
    start = [0, 0, 0]
    for i in range(L):
        for j in range(R):
            for k in range(C):
                if arr[i][j][k] == 'S':
                    start = [i, j, k]
                    break

    queue = deque([start])
    answer = False
    s[start[0]][start[1]][start[2]] = 1
    while queue:
        x = queue.popleft()
        for i in mv:
            y = [x[0] + i[0], x[1] + i[1], x[2] + i[2]]
            if 0 <= y[0] < L and 0 <= y[1] < R and 0 <= y[2] < C:
                if s[y[0]][y[1]][y[2]] == 0 and arr[y[0]][y[1]][y[2]] != '#':
                    s[y[0]][y[1]][y[2]] = s[x[0]][x[1]][x[2]] + 1
                    queue.append(y)
                    if arr[y[0]][y[1]][y[2]] == 'E':
                        answer = True
                        print('Escaped in %s minute(s).' % (s[y[0]][y[1]][y[2]] - 1))
    if not answer:
        print("Trapped!")
