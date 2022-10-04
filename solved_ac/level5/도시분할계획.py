import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
arr = [100000000000] * (N + 1)
son = [[] for _ in range(N + 1)]
deq = deque([])

arr[0] = 0
arr[1] = 0

for _ in range(M):
    a, b, l = map(int, sys.stdin.readline().split())
    # if b == 1:
    #     arr[a] = l
    son[a].append([b, l])
    # son[b].append([a, l])


def find_answer():
    for i in range(len(arr)):
        arr[i] = 1000
    arr[0] = 0
    for i in son[1]:
        deq.append(i[0])
        arr[i[0]] = i[1]
    while deq:
        temp = deq.popleft()
        for [j, l] in son[temp]:
            if arr[j] > l:
                deq.append(j)
                arr[j] = l

def find_answer2(x):
    for i in range(len(arr)):
        arr[i] = 1000
    arr[0] = 0
    for i in son[x]:
        deq.append(i[0])
    while deq:
        temp = deq.popleft()
        for [j, l] in son[temp]:
            if arr[j] > l:
                deq.append(j)
                arr[j] = l
    arr[arr.index(max(arr))] = 0
    print(sum(arr) - max(arr))

# find_answer()
# arr[arr.index(max(arr))] = 0
# print(sum(arr) - max(arr))
find_answer2(1)