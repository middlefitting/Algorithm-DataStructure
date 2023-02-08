from collections import deque

N = int(input())
arr = [list(str(input())) for _ in range(N)]
M = int(input())
queue = deque(list(map(int, input().split())) for _ in range(M))


def circle(x, loc):
    if loc == 1:
        arr[x].insert(0, arr[x].pop())
    elif loc == -1:
        arr[x].append(arr[x].pop(0))


while queue:
    x, l = queue.popleft()
    x -= 1
    temp = deque([])
    temp.append([x, l])

    px = x
    pl = l
    lx = x
    ll = l
    while lx > 0:
        lx -= 1
        ll = ll * -1
        if arr[px][6] != arr[lx][2]:
            temp.append([lx, ll])
            px = lx
            ll = ll
        else:
            break
    px = x
    pl = l
    rx = x
    rl = l
    while rx < N - 1:
        rx += 1
        rl = rl * -1
        if arr[px][2] != arr[rx][6]:
            temp.append([rx, rl])
            px = rx
            ll = rl
        else:
            break
    while temp:
        tx, tloc = temp.popleft()
        circle(tx, tloc)
answer = 0
for i in range(N):
    if arr[i][0] == '1':
        answer += 1
print(answer)
