# import sys
# from collections import deque
#
#
# def find(a):
#     if uf[a] < 0:
#         return a
#     else:
#         # uf[a] = find(uf[a])
#         return find(uf[a])
#
#
# def renew(a, b):
#     if uf[b] < 0:
#         return
#     else:
#         l[a] = (l[a] + abs(b - uf[b])) % 1000
#         renew(a, uf[b])
#
#
# def merge(a, b):
#     if a == b:
#         uf[a] = -1
#         return
#     uf[a] = b
#     # if uf[b] == a:
#     #     uf[b] = -1
#     # for i in v[a]:
#     #     v[b].add(i)
#     # for i in v[b]:
#     #     # print(i)
#     #     l[i] = 0
#     #     renew(i, i)
#
#
# if __name__ == "__main__":
#     for i in range(int(sys.stdin.readline())):
#         N = int(sys.stdin.readline())
#         l = [0] * (N + 1)
#         uf = [-1] * (N + 1)
#         v = [set() for _ in range(N + 1)]
#         flag = 0
#         for i in range(1, N + 1):
#             v[i].add(i)
#         while True:
#             temp = list(map(str, sys.stdin.readline().split()))
#             if temp[0] == 'O':
#                 break
#             elif temp[0] == 'E':
#                 if not flag:
#                     l[int(temp[1])] = 0
#                     renew(int(temp[1]), int(temp[1]))
#                     flag = 1
#                 sys.stdout.write("%d \n" % l[int(temp[1])])
#             elif temp[0] == 'I':
#                 merge(int(temp[1]), int(temp[2]))
#                 flag = 0
#         # print(uf)
import sys


def find(a):
    if uf[a] < 0:
        return a
    p = find(uf[a])
    l[a] += l[uf[a]]
    uf[a] = p
    return p


def merge(a, b):
    l[a] = abs(a - b) % 1000
    uf[a] = b


if __name__ == "__main__":
    for i in range(int(sys.stdin.readline())):
        N = int(sys.stdin.readline())
        l = [0] * (N + 1)
        uf = [-1] * (N + 1)
        while True:
            temp = list(map(str, sys.stdin.readline().split()))
            if temp[0] == 'O':
                break
            elif temp[0] == 'E':
                find(int(temp[1]))
                sys.stdout.write("%d \n" % l[int(temp[1])])
            elif temp[0] == 'I':
                merge(int(temp[1]), int(temp[2]))