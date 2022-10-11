# 2
# 3
# Fred Barney
# Barney Betty
# Betty Wilma
# 3
# Fred Barney
# Betty Wilma
# Barney Betty

import sys

T = int(sys.stdin.readline())
uf = []


def find(a):
    if uf[a] < 0:
        return a
    uf[a] = find(uf[a])
    return uf[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    uf[a] = uf[a] + uf[b]
    uf[b] = a


for _ in range(T):
    name_arr = dict()
    M = int(sys.stdin.readline())
    uf = [-1] * (2 * M + 1)
    leng = 0
    for i in range(M):
        a, b = map(str, sys.stdin.readline().split())
        try:
            val_a = name_arr[a]
        except KeyError:
            name_arr[a] = leng
            val_a = leng
            leng = leng + 1
        try:
            val_b = name_arr[b]
        except KeyError:
            name_arr[b] = leng
            val_b = leng
            leng = leng + 1
        merge(val_a, val_b)
        print(uf[find(val_a)] * -1)
