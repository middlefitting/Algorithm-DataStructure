import sys

def find_len(a, b):
    return ((a[0] - b[0])**2 + (a[1] - b[1])**2)**0.5


def find(a):
    if mst[a] < 0:
        return a
    mst[a] = find(mst[a])
    return mst[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    mst[b] = a
    return True


T = int(sys.stdin.readline())
for _ in range(T):
    S, P = map(int, sys.stdin.readline().split())
    M = P - 1
    if S > 1:
        M = M - S + 1
    mst = [-1] * P
    arr = []
    len_arr = []
    for _ in range(P):
        arr.append(list(map(int, sys.stdin.readline().split())))
    for a in range(len(arr)):
        for b in range(len(arr)):
            len_arr.append([a, b, find_len(arr[a], arr[b])])
    len_arr.sort(key=lambda x: x[2])
    count = 0
    for temp in len_arr:
        if merge(temp[0], temp[1]):
            count += 1
        if count == M:
            print('%.2f' % temp[2])
            break
