from collections import deque


def plus(k):
    for i in range(1, k + 1):
        temp = queue.popleft()
        if i != k:
            queue.append(temp)
        else:
            print(temp, end="")
    return arr[temp - 1]


def minus(k):
    for i in range(1, (-1 * k) + 1):
        temp = queue.pop()
        if i != ( -1 * k):
            queue.appendleft(temp)
        else:
            print(temp, end="")
    return arr[temp - 1]


if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    queue = deque([i for i in range(2, N + 1)])
    print(1, end="")
    k = arr[0]
    while queue:
        print(" ", end="")
        if k > 0:
            k = plus(k)
        else:
            k = minus(k)
