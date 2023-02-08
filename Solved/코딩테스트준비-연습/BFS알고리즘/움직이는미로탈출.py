# 0 7
# 7 0
import sys
from collections import deque

arr = [list(str(input())) for _ in range(8)]
mv = [[0, 0], [1, 0], [-1, 0], [0, 1], [0, -1], [1, 1], [-1, 1], [1, -1], [-1, -1]]
queue = deque([])
temp = deque([])
queue.append([7, 0])

while queue:
    v = [[0] * 8 for _ in range(8)]
    while queue:
        x = queue.popleft()
        if x[0] == 0 and x[1] == 7:
            print(1)
            sys.exit()
        if arr[x[0]][x[1]] == '#':
            continue
        for mx, my in mv:
            tx = x[0] + mx
            ty = x[1] + my
            if 0 <= tx < 8 and 0 <= ty < 8:
                if v[tx][ty] == 0 and arr[tx][ty] == '.':
                    v[tx][ty] = 1
                    temp.append([tx, ty])
    while temp:
        queue.append(temp.popleft())
    for i in range(8):
        for j in range(8):
            if arr[7 - i][7 - j] == '#':
                arr[7 - i][7 - j] = '.'
                if i > 0:
                    arr[7 - i + 1][7 - j] = '#'

print(0)
