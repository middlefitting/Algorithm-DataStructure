import sys
sys.setrecursionlimit(200010)


def find(a):
    if uf[a] < 0:
        return a
    uf[a] = find(uf[a])
    return find(uf[a])


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    uf[b] = a


if __name__ == "__main__":
    N, Q = map(int, sys.stdin.readline().split())
    uf = [-1] * (N + 1)
    parent = [i for i in range(N + 1)]
    command = []
    answer = []
    for i in range(2, N + 1):
        parent[i] = int(sys.stdin.readline())
    for _ in range(N + Q - 1):
        command.append(list(map(int, sys.stdin.readline().split())))
    for i in range(N + Q - 1):
        # ind = N + Q - 2 - i
        # temp = command[ind]
        temp = command.pop()
        if temp[0] == 0 and len(temp) == 2:
            merge(parent[temp[1]], temp[1])
        elif temp[0] == 1 and len(temp) == 3:
            if find(temp[1]) == find(temp[2]):
                answer.append("YES")
            else:
                answer.append("NO")
    for i in range(len(answer)):
        # ind = len(answer) - i - 1
        # print(answer[ind])
        print(answer.pop())

