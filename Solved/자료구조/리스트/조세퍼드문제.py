from collections import deque


def yosqp():
    for i in range(1, K + 1):
        temp = queue.popleft()
        if i != K:
            queue.append(temp)
        else:
            if queue:
                print(temp, end=", ")
            else:
                print(temp, end=">")


if __name__ == '__main__':
    N, K = map(int, input().split())
    queue = deque([i for i in range(1, N + 1)])
    print("<", end="")
    while queue:
        yosqp()
