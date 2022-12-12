import sys
from collections import deque
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
target = "123456780"
arr = []
for i in range(3):
    arr.append(list(map(int, input().split())))
queue = deque([])
queue.append([arr, 0])
s = ""
for i in range(3):
    for j in range(3):
        s += str(arr[i][j])
v = set([])
v.add(s)
if s == target:
    print(0)
    sys.exit()
while queue:
    x, temp = queue.popleft()
    for i in range(3):
        for j in range(3):
            if x[i][j] == 0:
                for [dx, dy] in mv:
                    tx = i + dx
                    ty = j + dy
                    if 0 <= tx < 3 and 0 <= ty < 3:
                        t_arr = []
                        for _ in range(3):
                            t_arr.append(x[_].copy())
                        t_arr[i][j] = t_arr[tx][ty]
                        t_arr[tx][ty] = 0
                        s = ""
                        for p in range(3):
                            for q in range(3):
                                s += str(t_arr[p][q])
                        v_len = len(v)
                        v.add(s)
                        n_len = len(v)
                        if v_len < n_len:
                            queue.append([t_arr, temp + 1])
                            if s == target:
                                print(temp + 1)
                                sys.exit()
print(-1)
